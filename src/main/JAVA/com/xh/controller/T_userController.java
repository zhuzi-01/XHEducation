package com.xh.controller;

import com.sun.tracing.dtrace.Attributes;
import com.xh.entity.T_user;
import com.xh.service.IT_userService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
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
    @ResponseBody
    public String Login(HttpServletRequest request, String username,String password){
        T_user t_user2=userService.queryoneuserbyname(username);
        JSONObject json=new JSONObject();
        if (t_user2.getPassword().equals(password)){
            HttpSession session=request.getSession();
            session.setAttribute("user",t_user2);
             json.put("result","success");
        }else{
            json.put("result","fail");
        }
        return json.toString();
    }

    @RequestMapping("/islogin")
    @ResponseBody
    public String ISLogin(HttpServletRequest request){
        JSONObject json=new JSONObject();
        HttpSession session=request.getSession();
        T_user user= (T_user) session.getAttribute("user");
        System.out.println(user);
        if (user!=null){
            json.put("user",user);
            json.put("result","success");
        }else{
            json.put("result","fail");
        }
        return json.toString();
    }
}
