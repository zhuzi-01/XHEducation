package com.xh.controller;

import com.xh.entity.T_user;
import com.xh.entity.T_user_course_section;
import com.xh.service.IT_orderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class T_orderController {
    @Autowired
    IT_orderService orderService;

    @RequestMapping("/getorder")
    @ResponseBody
    public List<T_user_course_section> getorder(HttpServletRequest request){
        HttpSession session=request.getSession();
        T_user user= (T_user) session.getAttribute("user");
        return orderService.queryOrdersbyUserid(user.getId());
    }

}
