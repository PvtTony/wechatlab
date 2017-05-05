package me.songt.wechatlab.controller.rest;

import me.songt.wechatlab.service.UserService;
import me.songt.wechatlab.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2017/5/6.
 */
@RestController
public class UserController
{


    @Autowired
    private UserService userService;

    @GetMapping("/api/auth")
    public UserInfo authenticate(String user, String password)
    {
        return userService.authenticate(user, password);
    }


}
