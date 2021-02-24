package com.example.ccf.blImpl.conference;

import com.example.ccf.vo.ConferenceOmit;

import java.util.List;

public interface ConferenceBlService {

    List<ConferenceOmit> getConferenceOmit(List<String> meetings);
}
