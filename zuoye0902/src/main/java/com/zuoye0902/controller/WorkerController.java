package com.zuoye0902.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zuoye0902.pojo.Worker;
import com.zuoye0902.service.DepartmentService;
import com.zuoye0902.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class WorkerController {
    @Autowired
    private WorkerService ws;
    @Autowired
    private DepartmentService ds;
    @GetMapping("/getall")
    public String getall(Model model){
        model.addAttribute("workers", ws.select());
        model.addAttribute("departments", ds.select());
        return "index2";
    }
    @GetMapping("/getdeptno")
    public String getdeptno(Model model,int deptid){
        model.addAttribute("workers", ws.getWorkerBydeptid(deptid));
        model.addAttribute("departments", ds.select());
        return "index2";
    }
    @GetMapping("/del")
    public String delWorker(int wid){
        int no = ws.delect(wid);
        if(no > 0){
            return  "redirect:/getall";
        }else{
            return null;
        }
    }
    @GetMapping("/saveclick")
    public String saveclick(Model model){
        model.addAttribute("departments", ds.select());
            return  "adduser";
        }
    @GetMapping("/save")
    public String saveWorker(Worker worker){
        int no = ws.add(worker);
        if(no > 0){
            //保存成功，跳转到显示请求
            return  "redirect:/getall";
        }
        return null;
    }
    @GetMapping("/getworker")
    public String getworker(int wid, Model model){
        Worker w=ws.getWorkerByNo(wid);
        model.addAttribute("worker", w);
        model.addAttribute("departments", ds.select());
        return "userupdate";
    }
    @GetMapping("/update")
    public String updateWorker(Worker worker){
        int no = ws.update(worker);
        if(no > 0){
            return  "redirect:/getall";
        }else{
            return null;
        }
    }



}
