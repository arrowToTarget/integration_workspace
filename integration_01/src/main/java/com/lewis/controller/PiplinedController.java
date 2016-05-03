package com.lewis.controller;

import com.lewis.util.CacheUtil;
import com.lewis.util.VirtualDB;
import com.lewis.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangminghua on 2016/4/19.
 */
@Controller
@RequestMapping("/batch")
public class PiplinedController {

    @Resource
    private CacheUtil cacheUtil;

    @RequestMapping("/set")
    public String toPipline(){
        List<Person> personList = VirtualDB.getPersonList();
        System.out.println(personList.toString());
        cacheUtil.setBatchValues(personList);
        return "hello";
    }

    @RequestMapping("/get")
    public String getPip(){
        List<String> keys = new LinkedList<String>();
        keys.add("lewis001");
        keys.add("lewis002");
        keys.add("lewis003");
        keys.add("lewis004");
        keys.add("lewis005");
        keys.add("lewis006");
        keys.add("lewis007");
        List<Object> batchValues = cacheUtil.getBatchValues(keys);
        if (batchValues != null && batchValues.size() > 0) {
            for (Object obj : batchValues) {
                if (obj instanceof Map) {
                    Map<String ,Person> map = (Map<String,Person>)obj;
                    System.out.println(map);
                }
            }
        }
        return "hello";
    }
}
