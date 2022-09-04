package com.zuoye0831.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoye0831.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    public List<Goods> getAllgoods();
    public IPage<Goods> getGoods(int cid, int bid, String keyword, Integer pageno, String ordercol, int order);
    public List<Goods> getAllpages(@Param("index") Integer index,
                                   @Param("count") Integer count,
                                   @Param("cid") Integer cid,
                                   @Param("bid") Integer bid,
                                   @Param("x") String x);
}
