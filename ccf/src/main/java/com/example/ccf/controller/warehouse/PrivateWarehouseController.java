package com.example.ccf.controller.warehouse;

import com.example.ccf.bl.WarehouseService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse/private")
@CrossOrigin
public class PrivateWarehouseController {

    private WarehouseService warehouseService;

    @Autowired
    public void DI(WarehouseService warehouseService){
        this.warehouseService=warehouseService;
    }

    @RequestMapping(value = "/papers",method = RequestMethod.GET)
    public ResponseVO getPapers(){
        return warehouseService.getTeamPapers();
    }

    @RequestMapping(value = "/delete/{paperId}",method = RequestMethod.GET)
    public ResponseVO deletePaper(@PathVariable int paperId){
        return warehouseService.deletePaper(paperId);
    }
}
