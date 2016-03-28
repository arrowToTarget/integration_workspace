package com.lewis.controller;

import com.lewis.service.ITravelRecordService;
import com.lewis.vo.TravelRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/28.
 */
@Controller
@RequestMapping("/travelRecord")
public class TravelRecordController {

    @Resource
    private ITravelRecordService travelRecordService;

    @RequestMapping("/all")
    public String getAllTravelRecord(Model model){
        List<TravelRecord> allTravelRecordList = travelRecordService.getAllTravelRecord();
        model.addAttribute("list",allTravelRecordList);
        return "hello";
    }
}
