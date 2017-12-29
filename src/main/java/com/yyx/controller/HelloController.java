package com.yyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by alwayslike on 2017/11/27.
 */
@Controller
@RequestMapping("/")
public class HelloController {
//
//    @RequestMapping("/in")
//    public ModelAndView register(){
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName( "index" );  //返回的页面名称
////        modelAndView.addObject( " 需要放到 model 中的属性名称 " , " 对应的属性值，它是一个对象 " );  //返回的数据
//        return modelAndView;
//    }
@RequestMapping("/")
public String printHello(ModelMap model) {
    System.out.println("登录成功。。。。");
    return "index";
}
}

