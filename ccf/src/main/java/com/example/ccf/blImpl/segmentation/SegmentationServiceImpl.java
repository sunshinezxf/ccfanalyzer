package com.example.ccf.blImpl.segmentation;

import com.example.ccf.bl.segmentation.SegmentationService;
import com.example.ccf.data.segmentation.SegmentationMapper;
import com.example.ccf.po.*;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SegmentationServiceImpl implements SegmentationService {
    @Autowired
    private SegmentationMapper segmentationMapper;
    @Override
    public ResponseVO segmentation_title(int start_id) {
        List<SegmentationTitle> origin_sts= segmentationMapper.get_title(start_id);
        int size=origin_sts.size();
        for(int i=0;i<size;i++){
            int paper_id =origin_sts.get(i).getPaper_id();
//            System.out.println(paper_id);
//            System.out.println(origin_sts.get(i).getTitle());
            List<SegmentationTitle> new_sts=new ArrayList<>();
            String[] segmentation=segmentation(origin_sts.get(i).getTitle());
            for(int j=0;j<segmentation.length;j++) {
                if (segmentation[j].length() >= 4) {
                    SegmentationTitle st = new SegmentationTitle();
                    st.setTitle(segmentation[j]);
                    st.setPaper_id(paper_id);
                    new_sts.add(st);
                }
            }
            segmentationMapper.insert_segmentation_title(new_sts);
        }
        return  ResponseVO.buildSuccess("数据库1更新完成。");

    }

    @Override
    public ResponseVO segmentation_keyword(int start_id) {
        List<KeywordInf> keywordInf=segmentationMapper.get_keyword(start_id);
        List<KeywordInf> keywords=segmentationMapper.get_keywords();
        int size=keywordInf.size();
        List<KeywordInf> new_keywordInf=new ArrayList<>();
        for(int i=0;i<size;i++){

            int id= keywordInf.get(i).getPaper_id();
            String keyword=(keywords.get(keywordInf.get(i).getKeyword_id()-1).getKeyword());
            String[] ks=segmentation(keyword);
            for(int j=0;j<ks.length;j++){
                KeywordInf k= new KeywordInf();
                k.setKeyword(ks[j]);
                k.setPaper_id(id);
                new_keywordInf.add(k);
            }

        }
        segmentationMapper.insert_keyword(new_keywordInf);
        return ResponseVO.buildSuccess("数据库3更新成功");

    }
    public String[] segmentation(String title){
        String[] blank_words=title.split(" ");
        int size=blank_words.length;
        for(int i=0;i<size;i++){
            String word=blank_words[i].toLowerCase();
            for(int j1=0;j1<blank_words[i].length();j1++){
                if(word.charAt(j1) >= 'a' && word.charAt(j1) <= 'z'){
                    word=word.substring(j1);
                    break;
                }
            }
            for(int j2=word.length()-1;j2>=0;j2--){
                if(word.charAt(j2) >= 'a' && word.charAt(j2) <= 'z'){
                    word=word.substring(0,j2+1);
                    break;
                }
            }
            //System.out.println(word);
            blank_words[i]=word;

        }
        return blank_words;
    }

}
