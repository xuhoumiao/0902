package com.zuoye0831;

import com.zuoye0831.pojo.Goods;
import com.zuoye0831.pojo.MyPage;
import com.zuoye0831.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Zuoye0831ApplicationTests {

    @Autowired
    private GoodsService gs;
    @Test
    void contextLoads() {
        MyPage<Goods> myPage=gs.getAllpages(2,10,1,null,null);
        System.out.println(myPage);
    }

}
