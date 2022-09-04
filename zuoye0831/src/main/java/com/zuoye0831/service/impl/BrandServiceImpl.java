package com.zuoye0831.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zuoye0831.mapper.BrandMapper;
import com.zuoye0831.pojo.Brand;
import com.zuoye0831.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper bm;
    @Override
    public List<Brand> getALL() {
        return bm.selectList(null);
    }

    @Override
    public List<Brand> getBrands(Integer cid) {
        QueryWrapper<Brand> qw = new QueryWrapper<>();
        qw.select("distinct bname");
        if(cid != null && cid != 0){
            qw.eq("classid", cid);
        }
        return bm.selectList(qw);
    }
}
