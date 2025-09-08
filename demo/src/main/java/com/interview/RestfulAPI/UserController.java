package com.interview.RestfulAPI;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public String getInfo(){
        return "User info";
    } 

    @PostMapping("/login")
    public String login(@RequestBody User user){
        if(user == null) return "Login failed";
        
        if (!user.getName().equals("xiaoming") || !user.getPassword().equals("12345")) {
            return "Login failed";
        }else{
            return "Login successed";
        }
    }

}
