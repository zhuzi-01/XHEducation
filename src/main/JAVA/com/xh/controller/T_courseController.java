package com.xh.controller;


import com.sun.deploy.net.HttpResponse;
import com.sun.glass.ui.TouchInputSupport.TouchCountListener;
import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import com.xh.entity.T_course;
import com.xh.entity.T_course_image;
import com.xh.entity.T_user;
import com.xh.service.IT_classifyService;
import com.xh.service.IT_courseService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@SessionAttributes("course_id")
public class T_courseController {
    @Autowired
    IT_courseService courseService;
    @Autowired
    IT_classifyService classifyService;



    @RequestMapping("/courselist")
    @ResponseBody
    public String getcourses(Model model){
        JSONObject json=new JSONObject();
        List<String> images=new ArrayList<>();
        List<T_course> courses=courseService.getCoursesByPages(0,4);
        for (T_course course:courses ) {
            if (courseService.queryoneimage(course.getId())!=null){
                images.add(courseService.queryoneimage(course.getId()).getFilename());
            }else if(course.getId()<132){
                images.add(course.getId()+".jpg");
            }else{
                images.add("9999"+".jpg");
            }

        }
        json.put("images",images);
        json.put("courses",courses);
        return json.toString();
    }

    @RequestMapping("/courselist1")
    @ResponseBody
    public String getcoursesbypages(Model model,Integer currPage){
        final int PAGE_SIZE;
        if (currPage==999){
             PAGE_SIZE=5;
             currPage=new Random().nextInt((courseService.numofcourse()/PAGE_SIZE-1)+1)+1;
        }else if(currPage==9999){
            PAGE_SIZE=courseService.numofcourse();
            currPage=1;
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

        List<T_course> courses=courseService.getCoursesByPages((currPage-1)*PAGE_SIZE, PAGE_SIZE);
        JSONObject json=new JSONObject();
        List<String> images=new ArrayList<>();
        for (T_course course:courses ) {
            if (courseService.queryoneimage(course.getId())!=null){
                images.add(courseService.queryoneimage(course.getId()).getFilename());
            }else if(course.getId()<132){
                images.add(course.getId()+".jpg");
            }else{
                images.add("9999"+".jpg");
            }

        }
        json.put("images",images);
        json.put("courses",courses);
        json.put("pages",pages);
        json.put("count",count);

       return json.toString();
    }

    @RequestMapping("/getOnecourse")
    @ResponseBody
    public String getOnecourses(Integer course_id){
        System.out.println(course_id);
        JSONObject json=new JSONObject();
        List<T_course> list = new ArrayList<>();
        String  image="";
        if (courseService.queryoneimage(course_id)!=null){
            image=(courseService.queryoneimage(course_id).getFilename());
        }else if(course_id<132){
            image=(course_id+".jpg");
        }else{
            image=("9999"+".jpg");
        }
        list.add(courseService.getOnecourse(course_id));
        json.put("course",list);
        json.put("image",image);

        return json.toString();
    }

    @RequestMapping("/getcoursesbyclassify")
    @ResponseBody
    public String getcoursesbyclassify(Integer currPage,String num1,String num2){
       // int currPage=1; //前端传回来的当前页码
        if ("666".equals(num1))
            num1=null;
        if ("666".equals(num2))
            num2=null;
        T_course course=new T_course(num1,num2);
        List<T_course> courses=courseService.getCoursesbyclassify(course);
        System.out.println(courses);
        final int PAGE_SIZE;
        if (currPage==999){
            PAGE_SIZE=5;
            currPage=new Random().nextInt((courses.size()/PAGE_SIZE-1)+1)+1;
        }else{
            PAGE_SIZE=8; //每页显示8条
        }


        int count=courses.size();//总记录数
        int pages;//总页数
        if (count%PAGE_SIZE==0) {
            pages=count/PAGE_SIZE;
        } else {
            pages=count/PAGE_SIZE+1;
        }
        JSONObject json=new JSONObject();
        System.out.println(course);
        List<String> images=new ArrayList<>();
        for (T_course cour:courseService.getCoursesbyclassifywithPages((currPage-1)*PAGE_SIZE, PAGE_SIZE,course) ) {
            if (courseService.queryoneimage(cour.getId())!=null){
                images.add(courseService.queryoneimage(cour.getId()).getFilename());
            }else if(cour.getId()<132){
                images.add(cour.getId()+".jpg");
            }else{
                images.add("9999"+".jpg");
            }}
        json.put("images",images);
        json.put("courses",courseService.getCoursesbyclassifywithPages((currPage-1)*PAGE_SIZE, PAGE_SIZE,course));
        json.put("pages",pages);
        json.put("count",count);
        //json.put("courses",courses);
        //System.out.println(courses);
        return json.toString();
    }

    @RequestMapping("/searchcourse")
    @ResponseBody
    public String searchcourse(Integer currPage,String text){
//         currPage=2; //前端传回来的当前页码
//         text="中";
        List<T_course> courses=courseService.researchcourse(text);
        //System.out.println(courses);
        final int PAGE_SIZE;
        if (currPage==999){
            PAGE_SIZE=5;
            currPage=new Random().nextInt((courses.size()/PAGE_SIZE-1)+1)+1;
        }else{
            PAGE_SIZE=8; //每页显示8条
        }


        int count=courses.size();//总记录数
        int pages;//总页数
        if (count%PAGE_SIZE==0) {
            pages=count/PAGE_SIZE;
        } else {
            pages=count/PAGE_SIZE+1;
        }
        JSONObject json=new JSONObject();
        //System.out.println(course);
        List<String> images=new ArrayList<>();
        for (T_course cour:courseService.researchcourseByPages((currPage-1)*PAGE_SIZE, PAGE_SIZE,text) ) {
            if (courseService.queryoneimage(cour.getId())!=null){
                images.add(courseService.queryoneimage(cour.getId()).getFilename());
            }else if(cour.getId()<132){
                images.add(cour.getId()+".jpg");
            }else{
                images.add("9999"+".jpg");
            }
        }
        json.put("images",images);
        json.put("courses",courseService.researchcourseByPages((currPage-1)*PAGE_SIZE, PAGE_SIZE,text));
        json.put("pages",pages);
        json.put("count",count);
        //System.out.println(courses);
        return json.toString();
    }

    @RequestMapping("/delcourse")
    @ResponseBody
    public String delcourse(Integer id){
        JSONObject json=new JSONObject();
        if (courseService.delcourse(id)){
            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }

    @RequestMapping("/addcourse")
    @ResponseBody
    public String addcourse(T_course course){
        JSONObject json=new JSONObject();
        course.setStudyCount(0);
        course.setClassifyName(classifyService.queryclassify(Integer.parseInt(course.getClassify())).getName());
        course.setSubClassifyName(classifyService.queryclassify(Integer.parseInt(course.getSubClassify())).getName());
        if (courseService.addcourse(course)){
            json.put("result","ok");
              }else{
            json.put("result","error");
        }
        return json.toString();
    }

    @RequestMapping("/updatecourse")
    @ResponseBody
    public String updatecourse(T_course course){
        JSONObject json=new JSONObject();
        if (courseService.updatecourse(course)){
            json.put("result","ok");
        }else{
            json.put("result","error");
        }
        return json.toString();
    }

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file,@RequestParam("course_id")Integer id) throws IOException {
        String fileName = file.getOriginalFilename();
        String uuid=UUID.randomUUID().toString();
        File dest = new File(request.getSession().getServletContext().getRealPath("/pics/course/")+uuid+fileName);
        System.out.println(id);
        try {
                // 保存文件
             file.transferTo(dest);
            T_course_image image=new T_course_image();
            image.setId(id);
            image.setFilename(uuid+fileName);
            //System.out.println(image);
            if (courseService.queryoneimage(id)!=null){
                courseService.updateimage(image);
            }else{
                if(courseService.addimage(image)){
                    return "redirect:/X-admin/course.html?upload=success";
                }
            }


        }catch (IOException e){

            return "redirect:/X-admin/course.html?upload=error";
        }
        return "redirect:/X-admin/course.html?upload=error";
    }

    @RequestMapping("getimage")
    @ResponseBody
    public T_course_image getimage(Integer id){
        return  courseService.queryoneimage(id);
    }
}
