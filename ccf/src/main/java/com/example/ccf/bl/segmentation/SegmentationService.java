package com.example.ccf.bl.segmentation;

import com.example.ccf.vo.ResponseVO;

public interface SegmentationService {
    ResponseVO segmentation_title(int start_id);
    ResponseVO segmentation_keyword(int start_id);

}
