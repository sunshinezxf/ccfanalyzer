package com.example.ccf.bl;

import com.example.ccf.vo.ResponseVO;

public interface ConferenceService {

    ResponseVO getConferencePortrait(int conferenceId);

    ResponseVO getConferenceRelatedPapers(int conferenceId,int index);

}
