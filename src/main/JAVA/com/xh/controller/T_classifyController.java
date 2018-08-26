package com.xh.controller;

import com.xh.entity.T_course;
import com.xh.entity.T_course_classify;
import com.xh.service.IT_classifyService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class T_classifyController {
    @Autowired
    IT_classifyService classifyService;

    @RequestMapping("/getclassify")
    @ResponseBody
    public String getcoursesbyclassify(Model model){
        List<T_course_classify> list1=classifyService.querybyparentcode(0);
        List<T_course_classify> list2=classifyService.querybyparentcode(2);
        List<T_course_classify> list3=classifyService.querybyparentcode(1);
        List<T_course_classify> list4=new ArrayList<>();
        list4.addAll(list2);
        list4.addAll(list3);
        JSONObject json=new JSONObject();
        json.put("list1",list1);
        json.put("list2",list2);
        json.put("list3",list3);
        json.put("list4",list4);
        //json.put("courses",courses);
        return json.toString();
    }

    @RequestMapping("/getallclassify")
    @ResponseBody
    public List<T_course_classify> getcourses(Model model){

        return classifyService.queryall();
    }

    @RequestMapping("/delclassify")
    @ResponseBody
    public String delcourse(Integer id){
        JSONObject json=new JSONObject();
        if (classifyService.delclassify(id)){
            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }

    @RequestMapping("/addclassify")
    @ResponseBody
    public String addcourse(T_course_classify classify){
        JSONObject json=new JSONObject();
//        course.setStudyCount(0);
//        course.setClassifyName(classifyService.queryclassify(Integer.parseInt(course.getClassify())).getName());
//        course.setSubClassifyName(classifyService.queryclassify(Integer.parseInt(course.getSubClassify())).getName());
        if (classifyService.addclassify(classify)){
            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }

    @RequestMapping("/updateclassify")
    @ResponseBody
    public String updatecourse(T_course_classify classify){
        JSONObject json=new JSONObject();
        if (classifyService.updateclassify(classify)){
            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }
}
