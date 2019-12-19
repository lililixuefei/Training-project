package com.xuefei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "hello";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
