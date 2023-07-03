package com.uch.vueproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value="/login", method = RequestMethod.GET,produces = "application/json")
    public String login(String username,String password) {
        return "帳號: " + username + "\n密碼: " + password;
    }

}
