package com.example.ccf.blImpl.paper_upload;

import com.example.ccf.bl.paper_upload.PaperUploadService;
import com.example.ccf.blImpl.Session.SessionBIService;
import com.example.ccf.data.paper_upload.PaperUploadMapper;
import com.example.ccf.data.team_manage.TeamManageMapper;
import com.example.ccf.vo.*;
import com.example.ccf.blImpl.JWT.JwtUtilsBIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PaperUploadServiceImpl implements PaperUploadService {
    @Autowired
    private JwtUtilsBIService jwtUtilsBIService;
    @Autowired
    private PaperUploadMapper paperUploadMapper;
    @Autowired
    private TeamManageMapper teamManageMapper;
    @Autowired
    private SessionBIService sessionBIService;
    @Override
    public ResponseVO team_paper_upload(TeamPaperImport t){
        String token=t.getToken();
        int team_id=t.getTeam_id();
        Private_paper upload_paper=t.change();
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int right=teamManageMapper.member_if(user_id,team_id);
        if(right==0){
            return  ResponseVO.buildSuccess("你不是该团队的成员！");
        }
        String result=paper_check(upload_paper);
        if(result.equals("pass")){
            paperUploadMapper.insert_private_paper(upload_paper);
            int paper_id=upload_paper.getPaper_id();
            author_insert(paper_id,upload_paper.getAuthors());
            paperUploadMapper.insert_team_paper(team_id,paper_id);
            return ResponseVO.buildSuccess("上传成功！");
        }
        else{
            return ResponseVO.buildSuccess(result);
        }
    }
    @Override
    public ResponseVO private_paper_upload(UserPaperImport u){
        String token=u.getToken();
        Private_paper upload_paper=u.change();
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        String result=paper_check(upload_paper);
        if(result.equals("pass")){
            paperUploadMapper.insert_private_paper(upload_paper);
            int paper_id=upload_paper.getPaper_id();
            author_insert(paper_id,upload_paper.getAuthors());
            paperUploadMapper.insert_user_paper(user_id,paper_id);
            return ResponseVO.buildSuccess("上传成功！");
        }
        else{
            return ResponseVO.buildSuccess(result);
        }
    }
    @Override
    public ResponseVO team_paper_alter(TeamPaperImport t){
        String token=t.getToken();
        int team_id=t.getTeam_id();
        Private_paper upload_paper=t.change();
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int right=teamManageMapper.member_if(user_id,team_id);
        if(right==0){
            return  ResponseVO.buildSuccess("你不是该团队的成员！");
        }
        String result=paper_check(upload_paper);
        if(result.equals("pass")){
            paperUploadMapper.alter_private_paper(upload_paper);
            int paper_id=upload_paper.getPaper_id();
            paperUploadMapper.delete_private_paper_authors(paper_id);
            author_insert(paper_id,upload_paper.getAuthors());
            return ResponseVO.buildSuccess("修改成功！");
        }
        else{
            return ResponseVO.buildSuccess(result);
        }
    }
    @Override
    public ResponseVO private_paper_alter(UserPaperImport u){
        String token=u.getToken();
        Private_paper upload_paper=u.change();
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        String result=paper_check(upload_paper);
        if(result.equals("pass")){
            paperUploadMapper.alter_private_paper(upload_paper);
            int paper_id=upload_paper.getPaper_id();
            paperUploadMapper.delete_private_paper_authors(paper_id);
            author_insert(paper_id,upload_paper.getAuthors());
            return ResponseVO.buildSuccess("修改成功！");
        }
        else{
            return ResponseVO.buildSuccess(result);
        }
    }
    public void author_insert(int paper_id,List<String> authors){
        List<Private_Author> private_authors=new ArrayList<>();
        for(int i=0;i<authors.size();i++){
            Private_Author private_author=new Private_Author();
            private_author.setPaper_id(paper_id);
            private_author.setAuthor(authors.get(i));
            private_authors.add(private_author);
        }
        paperUploadMapper.insert_paper_author(private_authors);
    }
    public String paper_check(Private_paper upload_paper){
        Calendar cal = Calendar.getInstance();
        List<String> authors=upload_paper.getAuthors();
        String title=upload_paper.getTitle();
        String abs=upload_paper.getAbstracts();
        String doi=upload_paper.getDoi();
        int citation=upload_paper.getCitation();
        String book_title=upload_paper.getBook_title();
        String pages=upload_paper.getPages();
        String publisher=upload_paper.getPublisher();
        String year=upload_paper.getYear();
        int y=Integer.parseInt(year);
        String url=upload_paper.getUrl();
        String time=upload_paper.getTime();
        String bib_url=upload_paper.getBib_url();
        String bib_source=upload_paper.getBib_source();
        //作者只允许英文空格和点
        String author_check="^[A-Za-z .]+$";
        //标题只允许出现两次数字和部分特殊符号
        String title_check="^[A-Za-z-, :.'?]*[0-9]*[A-Za-z-, :.'?]*[0-9]*[A-Za-z-, :.'?]+$";
        //简介允许出现部分特殊符号
        String abs_check="^[\\w-, :.'?()_]+$";
        //需要 数字.数字/字符串 的形式
        String doi_check="^[0-9]+[.][0-9]+[/][\\w-.]+$";
        //引用数不能超过上限
        int max_citation=Integer.MAX_VALUE;
        //出版刊物标题允许部分特殊符号
        String book_title_check="^[\\w-, :.'?]+$";
        //页数需要 页数--(-)页数 的形式
        String pages_check="^[0-9]{1,4}[-]{1,2}[0-9]{1,4}$";
        //出版商简称需大写且长度不宜过长
        String publisher_check="^[A-Z]{3,10}$";
        //年份检查
        int now_year=cal.get(Calendar.YEAR);
        //url开头必须是如此形式
        String url_check="^https://doi.org/[0-9]+[.][0-9]+[/][\\w-.]+$";
        //按照周几简写 日 月(简写) 年的形式
        String time_check="^[A-Za-z]{3,4}[ ][0-9]{2}[ ][A-Za-z]{3,4}[ ][0-9]{4}$";
        //网站形式,允许部分符号
        String bib_url_check="^https://[\\w/._\\-?]+$";
        //允许一些特殊符号
        String bib_source_check="^[\\w/:. ,\\-]+$";
        int size=authors.size();
        if(size==0)
            return "你需要填写作者名称。";
        else{
            for(int i=0;i<size;i++){
                if(!Pattern.matches(author_check,authors.get(i)))
                    return "作者名称只能包含英文空格点。";
            }
        }
        if(!Pattern.matches(title_check,title))
            return "标题只能包含-, :.'?符号且只能出现两次数字。";
        if(!Pattern.matches(abs_check,abs))
            return "简介只能包含-, :.'?()_符号。";
        if(!Pattern.matches(doi_check,doi))
            return "需要 数字.数字/字符串 的形式。";
        if(citation>=max_citation||citation<0)
            return "引用数超过上限或者为负数。";
        if(book_title==""||book_title==null){

        }
        else{
            if(!Pattern.matches(book_title_check,book_title))
                return "出版刊物标题允许-, :.'?符号。";
        }
        if(pages==""||pages==null){

        }
        else{
            if(!Pattern.matches(pages_check,pages))
                return "页数需要 页数--(-)页数 的形式，并且页数不能超过4位数。";
        }
        if(!Pattern.matches(publisher_check,publisher))
            return "出版商简称需大写且长度不宜过长。";
        if(y<1960||y>now_year)
            return "年份不合法。";
        if(url==""||url==null){

        }
        else{
            if(!Pattern.matches(url_check,url))
                return "url开头必须为https://doi.org/，必须以doi形式结尾。";
        }
        if (time == null || time == "") {

        }
        else {
            if (!Pattern.matches(time_check, time))
                return "按照周几(简写) 日 月(简写) 年的形式";
        }
        if(bib_url==null||bib_url==""){

        }
        else{
            if(!Pattern.matches(bib_url_check,bib_url))
                return "必须以https://开头,允许/._-?符号";
        }
        if(bib_source==""||bib_source==null){

        }
        else{
            if(!Pattern.matches(bib_source_check,bib_source))
                return "允许:. ,-符号";
        }
        return "pass";
    }

}
