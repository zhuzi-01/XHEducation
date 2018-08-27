package com.xh.controller;

import com.sun.tracing.dtrace.Attributes;
import com.xh.entity.T_course_section;
import com.xh.entity.T_user;
import com.xh.entity.T_user_course_section;
import com.xh.service.IT_orderService;
import com.xh.service.IT_userService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class T_userController {
    @Autowired
    IT_userService userService;
    @Autowired
    IT_orderService orderService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/app/index.html";
        //return "redirect:/app/index.html";

    }
    @RequestMapping("/z")
    public String adim(){
        return "redirect:/X-admin/login.html";
        //return "redirect:/app/index.html";

    }
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(String username,String password){
        T_user user=new T_user();
        user.setUsername(username);
        user.setPassword(password);
        user.setWeight(0);
        user.setProvince("中国");
        user.setEducation("保密");
        user.setGender(3);
        user.setCity("保密");
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

    @RequestMapping("/loginout")
    @ResponseBody
    public String loginout(HttpServletRequest request){
        JSONObject json=new JSONObject();
        HttpSession session=request.getSession();
        T_user user= (T_user) session.getAttribute("user");
        System.out.println(user);
        if (user!=null){
            session.removeAttribute("user");
            json.put("result","success");
        }else{
            json.put("result","fail");
        }
        return json.toString();
    }

    @RequestMapping("/adminLogin")
    //@ResponseBody
    public String adminLogin(HttpServletRequest request, String username,String password){
        T_user t_user2=userService.queryoneuserbyname(username);
        System.out.println(t_user2);
        if (t_user2!=null&&(password.equals(t_user2.getPassword())&&"999".equals(t_user2.getWeight().toString()))){
            HttpSession session=request.getSession();
            session.setAttribute("admin",t_user2);
            return "redirect:/X-admin/index.html";
        }else{
            return "redirect:/X-admin/login.html?message=error";
        }
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    public T_user userinfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        T_user user = (T_user) session.getAttribute("admin");
        return user;
    }
    @RequestMapping("/userlist")
    @ResponseBody
    public List<T_user> userinfo(){
        List<T_user> users=userService.queryall();
        return users;
    }
    @RequestMapping("/deleteuser")
    @ResponseBody
    public  String deleteUserById(Integer id){

        JSONObject json=new JSONObject();
        if (userService.deluser(id)) {
            for (T_user_course_section orders:orderService.queryOrdersbyUserid(id) ) {
                orderService.delorder(orders.getId());
            }
            json.put("result","success");
          }else{
            json.put("result","error");
        }
        return json.toString();
    }
    @RequestMapping("/updateuser")
    @ResponseBody
    public  String updateuser(@ModelAttribute T_user user){
        System.out.println(user);
        JSONObject json=new JSONObject();
        if (userService.updateuser(user)) {

            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }

    @RequestMapping("/updatepwd")
    @ResponseBody
    public  String updatepwd(@RequestParam("id") Integer id, @RequestParam("oldpass") String oldpass,@RequestParam("newpass") String newpass){

        JSONObject json=new JSONObject();
        T_user user=new T_user();
        user.setId(id);
        user.setPassword(newpass);
        System.out.println(user+newpass);
        if (oldpass.equals(userService.queryoneuser(id).getPassword())&&userService.updatepwd(user)) {

            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public T_user getuser(Integer id){
        T_user user=userService.queryoneuser(id);
        return user;
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public  String adduser(@ModelAttribute T_user user){
        System.out.println(user);
        JSONObject json=new JSONObject();
        user.setWeight(0);
        user.setProvince("中国");
        user.setEducation("保密");
        if (userService.adduser(user)) {

            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }
}
