package com.xh.controller;

import com.sun.tracing.dtrace.Attributes;
import com.xh.entity.T_user;
import com.xh.service.IT_userService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class T_userController {
    @Autowired
    IT_userService userService;

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(String username,String password){
        T_user user=new T_user();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user);
        JSONObject json=new JSONObject();



        if (userService.adduser(user)){
            json.put("result","success");
        }else{
            json.put("result","fail");
        }
        return json.toString();
    }

    @RequestMapping("/login")
    public String Login(HttpServletRequest request, T_user user){
        System.out.println(user);
        T_user t_user2=userService.queryoneuser(user.getId());

        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        return "order";
    }
}
