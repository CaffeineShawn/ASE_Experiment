package com.gdut.software.service;

import com.gdut.software.mapper.ScoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    public List<HashMap> getScoreInformation(int id){
        return scoreMapper.getScoreInformation(id);
    }
}
