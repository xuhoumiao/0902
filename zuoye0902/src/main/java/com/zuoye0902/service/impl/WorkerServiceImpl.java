package com.zuoye0902.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zuoye0902.mapper.WorkerMapper;
import com.zuoye0902.pojo.Worker;
import com.zuoye0902.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper wm;


    @Override
    public int add(Worker worker) {
        return wm.insert(worker);
    }

    @Override
    public int delect(Integer wid) {
        return wm.deleteById(wid);
    }

    @Override
    public int update(Worker worker) {
        return wm.updateById(worker);
    }

    @Override
    public List<Worker> select() {
        return wm.selectList(null);
    }

    @Override
    public Worker getWorkerByNo(Integer wid) {

        return wm.selectById(wid);
    }

    @Override
    public List<Worker> getWorkerBydeptid(Integer deptid) {
        QueryWrapper qw=new QueryWrapper();
        qw.eq("deptid",deptid);
        return wm.selectMaps(qw);
    }
}
