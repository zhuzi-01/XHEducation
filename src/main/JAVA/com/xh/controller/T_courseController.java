package com.xh.controller;


import com.sun.deploy.net.HttpResponse;
import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import com.xh.entity.T_course;
import com.xh.entity.T_user;
import com.xh.service.IT_courseService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@SessionAttributes("course_id")
public class T_courseController {
    @Autowired
    IT_courseService courseService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/app/index.html";

    }

    @RequestMapping("/courselist")
    @ResponseBody
    public List<T_course> getcourses(Model model){

        return courseService.getCoursesByPages(0,4);
    }

    @RequestMapping("/courselist1")
    @ResponseBody
    public String getcoursesbypages(Model model,Integer currPage){
        final int PAGE_SIZE;
        if (currPage==999){
             PAGE_SIZE=5;
             currPage=new Random().nextInt((courseService.numofcourse()/PAGE_SIZE-1)+1)+1;
        }else{
             PAGE_SIZE=8; //每页显示8条
        }

        //int currPage=1; //前端传回来的当前页码

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

    @RequestMapping("/getOnecourse")
    @ResponseBody
    public List<T_course> getOnecourses(Model model,Integer course_id){
        System.out.println(course_id);
        List<T_course> list = new ArrayList<>();
        list.add(courseService.getOnecourse(course_id));
        return list;
    }

    @RequestMapping("/getcoursesbyclassify")
    @ResponseBody
    public String getcoursesbyclassify(Model model,Integer currPage){
//        final int PAGE_SIZE;
//        if (currPage==999){
//            PAGE_SIZE=5;
//            currPage=new Random().nextInt((courseService.numofcourse()/PAGE_SIZE-1)+1)+1;
//        }else{
//            PAGE_SIZE=8; //每页显示8条
//        }

        //int currPage=1; //前端传回来的当前页码

//        int count=courseService.numofcourse();//总记录数
//        int pages;//总页数
//        if (count%PAGE_SIZE==0) {
//            pages=count/PAGE_SIZE;
//        } else {
//            pages=count/PAGE_SIZE+1;
//        }
        JSONObject json=new JSONObject();
        //json.put("courses",courseService.getCoursesByPages((currPage-1)*PAGE_SIZE, PAGE_SIZE));
        //json.put("pages",pages);
        T_course course=new T_course("1","5");
        json.put("courses",courseService.getCoursesbyclassify(course));
        return json.toString();
    }


}
