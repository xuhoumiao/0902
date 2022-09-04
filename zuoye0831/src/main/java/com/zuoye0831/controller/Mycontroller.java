package com.zuoye0831.controller;

import com.zuoye0831.service.BrandService;
import com.zuoye0831.service.ClassifyService;
import com.zuoye0831.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mycontroller {
    @Autowired
    private GoodsService gs;
    @Autowired
    private BrandService bs;
    @Autowired
    private ClassifyService cs;
    @GetMapping("/empallPage")
    public String allpage(Model model, Integer pno, Integer psize,Integer cid, Integer bid, String x){
        model.addAttribute("info",gs.getAllpages(pno,psize,cid,bid,x));
        model.addAttribute("brand",bs.getALL());
        model.addAttribute("classifys",cs.getALL());
        return "good";
    }
    @GetMapping("/empallPage2")
    public String bygname(Model model, Integer pno, Integer psize){
        model.addAttribute("info",gs.getAllpagesbygname(pno,psize));
        model.addAttribute("brand",bs.getALL());
        model.addAttribute("classifys",cs.getALL());
        return "good";
    }
    @GetMapping("/empallPage3")
    public String like(Model model, Integer pno, Integer psize,Integer cid, Integer bid, String x){
        model.addAttribute("info",gs.getlike(pno,psize,cid,bid,x));
        model.addAttribute("brand",bs.getALL());
        model.addAttribute("classifys",cs.getALL());
        return "good";
    }
}
