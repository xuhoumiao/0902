package com.zuoye0831.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zuoye0831.mapper.GoodsMapper;
import com.zuoye0831.pojo.Goods;
import com.zuoye0831.pojo.MyPage;
import com.zuoye0831.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper gm;

    @Override
    public MyPage<Goods> getAllpages(Integer pageno, Integer pagesize,Integer cid,Integer bid,String x) {
        int pno =pageno==null ? 1:pageno;
        int psize=pagesize==null ? 5 :pagesize;
        MyPage<Goods> myPage=new MyPage<>();
        myPage.setCurrent(pno);
        myPage.setSize(psize);
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        if(cid !=null&&cid!=0&& !cid.equals("")){
            qw.eq("cid",cid);
        }
        if(bid !=null &&bid!=0&& !bid.equals("")){
            qw.eq("bid",bid);
        }
        if(x !=null && !x.equals("")){
            qw.like("gname",x);
            qw.or().like("number",x);
        }
        myPage.setTotal(gm.selectCount(qw));
        List<Goods> list =gm.getAllpages((pno-1)*psize,psize,cid,bid,x);
        myPage.setList(list);
        return myPage;
    }

    @Override
    public MyPage<Goods> getAllpagesbygname(Integer pageno, Integer pagesize) {
        int pno =pageno==null ? 1:pageno;
        int psize=pagesize==null ? 5 :pagesize;
        MyPage<Goods> myPage=new MyPage<>();
        myPage.setCurrent(pno);
        myPage.setSize(psize);

        myPage.setTotal(gm.selectCount(null));
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.orderByAsc("gname");
//        qw.last("limit 1,5" );
        List<Goods> list =gm.selectList(qw);
        myPage.setList(list);
        return myPage;
    }

    @Override
    public MyPage<Goods> getlike(Integer pageno, Integer pagesize,Integer cid, Integer bid, String x) {
        int pno =pageno==null ? 1:pageno;
        int psize=pagesize==null ? 5 :pagesize;
        MyPage<Goods> myPage=new MyPage<>();
        myPage.setCurrent(pno);
        myPage.setSize(psize);
        myPage.setTotal(gm.selectCount(null));
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        if(cid !=null&& cid.equals("")){
            qw.eq("cid",cid);
        }
        if(bid !=null && bid.equals("")){
            qw.eq("bid",bid);
        }
        if(x !=null && x!=""){
            qw.like("gname",x);
            qw.or().like("number",x);
        }
        List<Goods> list =gm.selectList(qw);
        myPage.setList(list);
        return myPage;
    }

    @Override
    public IPage<Goods> getGoods(int cid, String bname, String keyword, Integer pageno, String ordercol, int order ) {
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        if(cid != 0){
            qw.eq("cid", cid);
        }
//        if(bid != 0){
//            qw.eq("bid", bid);
//        }
        if(bname != null && !bname.equals("")){
            qw.inSql("bid", "select bid from brand where bname = '"+bname+"'");
        }
        if(keyword != null){
            qw.and(wrapper ->
                    wrapper.like("number", keyword)
                            .or()
                            .like("gname", keyword)
            );
        }
        if(ordercol != null){
            if(order == 0){
                qw.orderByAsc(ordercol);
            }else{
                qw.orderByDesc(ordercol);
            }
        }

        int pno = pageno == null ? 1 : pageno;
        IPage<Goods> page = new Page<>(pno, 5);
        return gm.selectPage(page,qw);
    }
}
