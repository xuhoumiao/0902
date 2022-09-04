package com.zuoye0902.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zuoye0902.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {
    public List<Worker> getAllWorkers();

}
