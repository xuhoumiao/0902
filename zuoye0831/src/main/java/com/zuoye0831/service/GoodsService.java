package com.zuoye0831.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoye0831.pojo.Goods;
import com.zuoye0831.pojo.MyPage;

public interface GoodsService {
    public MyPage<Goods> getAllpages(Integer pageno, Integer pagesize,Integer cid,Integer bid,String x);
    public MyPage<Goods> getAllpagesbygname(Integer pageno, Integer pagesize);
    public MyPage<Goods> getlike(Integer pageno, Integer pagesize,Integer cid,Integer bid,String x);
    public IPage<Goods> getGoods(int cid, String bname, String keyword, Integer pageno, String ordercol, int order);

}
