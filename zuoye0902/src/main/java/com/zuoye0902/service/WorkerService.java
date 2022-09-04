package com.zuoye0902.service;

import com.zuoye0902.pojo.Worker;

import java.util.List;

public interface WorkerService {
    public int add(Worker worker);
    public int delect(Integer wid);
    public int update(Worker worker);
    public List<Worker> select();
    public Worker getWorkerByNo(Integer wid);
    public List<Worker> getWorkerBydeptid(Integer deptid);
}
