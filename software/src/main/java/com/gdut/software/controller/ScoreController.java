package com.gdut.software.controller;

import com.alibaba.fastjson.JSON;
import com.gdut.software.service.ScoreService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @RequestMapping("/getScoreInformation/{id}")
    public String getScoreInformation(@PathVariable int id){
        List<HashMap> lMap = scoreService.getScoreInformation(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("ScoreInfo", lMap);
        return JSON.toJSONString(map);
    }
}
