package com.xh.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;

import com.xh.entity.T_course;
import com.xh.service.IT_courseService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class T_courseController {
    @Autowired
    IT_courseService courseService;

    @RequestMapping("/courselist")
    @ResponseBody
    public List<T_course> getcourses(Model model){

        return courseService.getCoursesByPages(0,4);
    }

    @RequestMapping("/courselist1")
    @ResponseBody
    public String getcoursesbypages(Model model,Integer currPage){

        //int currPage=1; //前端传回来的当前页码
        final int PAGE_SIZE=8; //每页显示8条
        int count=courseService.numofcourse();//总记录数
        int pages;//总页数
        if (count%PAGE_SIZE==0) {
            pages=count/PAGE_SIZE;
        } else {
            pages=count/PAGE_SIZE+1;
        }
        JSONObject json=new JSONObject();
        json.put("courses",courseService.getCoursesByPages((currPage-1)*PAGE_SIZE, PAGE_SIZE));
        json.put("pages",pages);

       return json.toString();
    }

    @RequestMapping("/")
    public String index(){
        return "forward:/app/index.html";
    }
}
