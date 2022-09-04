package com.zuoye0831.service;

import com.zuoye0831.pojo.Brand;
import com.zuoye0831.pojo.Classify;

import java.util.List;

public interface BrandService {
    public List<Brand> getALL();
    public List<Brand> getBrands(Integer cid);
}
