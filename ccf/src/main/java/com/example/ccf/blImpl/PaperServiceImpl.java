package com.example.ccf.blImpl;

import com.example.ccf.bl.PaperService;
import com.example.ccf.data.paper.PaperMapper;
import com.example.ccf.po.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl implements PaperService {

    private PaperMapper paperMapper;

    @Autowired
    public void DI(PaperMapper paperMapper){
        this.paperMapper=paperMapper;
    }

    public Paper getPaperById(int paper_id){
        return paperMapper.getPaperById(paper_id);
    }

}
