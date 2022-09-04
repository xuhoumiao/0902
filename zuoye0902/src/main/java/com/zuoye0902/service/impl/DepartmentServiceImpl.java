package com.zuoye0902.service.impl;

import com.zuoye0902.mapper.DepartmentMapper;
import com.zuoye0902.pojo.Department;
import com.zuoye0902.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper dm;
    @Override
    public List<Department> select() {
        return dm.selectList(null);
    }
}
