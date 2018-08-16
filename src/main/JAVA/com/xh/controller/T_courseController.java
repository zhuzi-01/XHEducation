package com.xh.controller;

import com.xh.entity.T_course;
import com.xh.service.IT_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class T_courseController {
    @Autowired
    IT_courseService courseService;

    @RequestMapping("/courselist")
    @ResponseBody
    public List<T_course> getcourses(Model model){

        return courseService.getCourses();
    }

    @RequestMapping("/")
    public String index(){
        return "forward:/app/index.html";
    }
}
