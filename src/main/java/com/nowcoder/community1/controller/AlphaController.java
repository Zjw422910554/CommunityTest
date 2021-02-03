package com.nowcoder.community1.controller;

import com.nowcoder.community1.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by a4229 on 2021/1/28 10:58.
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "简短的字符串";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String s = enumeration.nextElement();
            String header = request.getHeader(s);
            System.out.println(s+" "+header);
        }
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>niuke</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "name" ,required = false,defaultValue = "2") int current,
            @RequestParam(name = "age" ,required = false,defaultValue = "2") int limit){
        return current+"   "+limit;
    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @PathVariable("id") int id){
        System.out.println(id);
        return id+"";
    }

    @RequestMapping(path = "/students",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudents(
            @RequestParam(name = "name" ,required = false,defaultValue = "2") String name,
            @RequestParam(name = "age" ,required = false,defaultValue = "2") String age){
        return name+"   "+age+"saveStudents";
    }

    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("name","zhangsan");
            modelAndView.addObject("age",30);
            modelAndView.setViewName("/demo/view");
            return modelAndView;
    }

    @RequestMapping(path = "/teacher2", method = RequestMethod.GET)
    public String getTeacher2(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","zhangsan");
        modelAndView.addObject("age",30);

        return "/demo/view";
    }
}
