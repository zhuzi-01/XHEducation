package com.xh.controller;

import com.xh.entity.T_course;
import com.xh.entity.T_user;
import com.xh.entity.T_user_course_section;
import com.xh.service.IT_courseService;
import com.xh.service.IT_orderService;
import com.xh.service.IT_userService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class T_orderController {
    @Autowired
    IT_orderService orderService;
    @Autowired
    IT_courseService courseService;
    @Autowired
    IT_userService userService;

    @RequestMapping("/getorder")
    @ResponseBody
    public String getorder(HttpServletRequest request){
        HttpSession session=request.getSession();
        T_user user= (T_user) session.getAttribute("user");
        List<T_user_course_section> orders= orderService.queryOrdersbyUserid(user.getId());
        List<String> names= new ArrayList<>();
        List<String> images=new ArrayList<>();
        for (T_user_course_section order:orders) {
          names.add(courseService.getOnecourse(order.getCourseId()).getName());
            if (courseService.queryoneimage(order.getCourseId())!=null){
                images.add(courseService.queryoneimage(order.getCourseId()).getFilename());
            }else{
                images.add(order.getCourseId()+".jpg");
            }
        }
        JSONObject json=new JSONObject();
        json.put("orders",orders);
        json.put("images",images);
        json.put("names",names);
        return json.toString();
    }

    @RequestMapping("/getAllorder")
    @ResponseBody
    public String getAllorder(HttpServletRequest request){

        List<T_user_course_section> orders= orderService.queryall();
        List<String> names= new ArrayList<>();
        List<String> usernames= new ArrayList<>();
        for (T_user_course_section order:orders) {
            names.add(courseService.getOnecourse(order.getCourseId()).getName());
            usernames.add(userService.queryoneuser(order.getUserId()).getUsername());
        }
        JSONObject json=new JSONObject();
        json.put("orders",orders);
        json.put("names",names);
        json.put("usernames",usernames);
        return json.toString();
    }
    @RequestMapping("/delorder")
    @ResponseBody
    public String delorder(Integer id){
        JSONObject json=new JSONObject();
        if (orderService.delorder(id)){
            json.put("result","success");
        }else{
            json.put("result","fail");
        }
        return json.toString();
    }

    @RequestMapping("/delAllorder")
    @ResponseBody
    public String delAllorder(HttpServletRequest request){
        HttpSession session=request.getSession();
        T_user user= (T_user) session.getAttribute("user");
        List<T_user_course_section> orders= orderService.queryOrdersbyUserid(user.getId());
        JSONObject json=new JSONObject();
        int i = 0;
        for (T_user_course_section order:orders) {
            orderService.delorder(order.getId());
            i++;
        }
        if (i==orders.size()){
            json.put("result","success");
        }else{
            json.put("result","fail");
        }
        return json.toString();
    }

    @RequestMapping("/addorder")
    @ResponseBody
    public String addorder(HttpServletRequest request,Integer course_id){
        HttpSession session=request.getSession();
        T_user user= (T_user) session.getAttribute("user");
        JSONObject json=new JSONObject();
        T_user_course_section order=new T_user_course_section();
        int rate=0;
        int level=courseService.getOnecourse(course_id).getLevel();
        if (level==1){
            rate=0;
        }else if (level==2){
            rate=30;
        }else{
            rate=60;
        }
        if (user!=null){
            json.put("result","success");
            order.setUserId(user.getId());
            order.setCourseId(course_id);
            order.setRate(rate);
            order.setCreateTime(new Date());
            order.setStatus(1);
            orderService.addorder(order);
        }else{
            json.put("result","fail");
        }
        return json.toString();
    }
}
