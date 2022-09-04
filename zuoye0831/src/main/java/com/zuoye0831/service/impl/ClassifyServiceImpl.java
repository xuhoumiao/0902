package com.zuoye0831.service.impl;

import com.zuoye0831.mapper.ClassifyMapper;
import com.zuoye0831.pojo.Classify;
import com.zuoye0831.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper cm;
    @Override
    public List<Classify> getALL() {
        return cm.selectList(null);
    }
}
