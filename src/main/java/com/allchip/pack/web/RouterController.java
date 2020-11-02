package com.allchip.pack.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 路径跳转
 */
@Controller
public class RouterController {

    @RequestMapping({"/hello"})
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

    @RequestMapping({"/"})
    public String index(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "index";
    }

    @RequestMapping(path = {"/{page}.html" , "/{page}"})
    public String toPage(@PathVariable String page , Map<String , Object> map){
        map.put("page" , page);
        return page;
    }

    @RequestMapping(path = {"/contractDetailPage/{id}"})
    public ModelAndView toContractDetailPage(@PathVariable(value = "id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contractDetailPage");
        modelAndView.addObject("id", id);
        return modelAndView;
    }
    @RequestMapping(path = {"/editContractPage/{id}"})
    public ModelAndView toEditContractPage(@PathVariable(value = "id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editContractPage");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

}

