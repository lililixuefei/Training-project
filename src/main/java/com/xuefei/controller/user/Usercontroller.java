package com.xuefei.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Usercontroller {

    @GetMapping("/userList")
    public String userList(){
        return "UserList";
    }


}
