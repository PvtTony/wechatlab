package me.songt.wechatlab.controller.rest;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.songt.wechatlab.service.UserService;
import me.songt.wechatlab.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2017/5/6.
 */
@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/api/bind/student")
    public UserInfo bindStudent(@RequestParam int studentId,
                                @RequestParam String password,
                                @RequestParam String openId)
    {
        return userService.bindStudent(studentId, password, openId);
    }

    @GetMapping("/api/bind/teacher")
    public UserInfo bindTeacher(@RequestParam int teacherId,
                                @RequestParam String password,
                                @RequestParam String openId)
    {
        return userService.bindTeacher(teacherId, password, openId);
    }

    /*@GetMapping("/api/user/openid")
    public String getOpenId(@RequestParam String code, @RequestParam String state)
    {
        try
        {
            WxMpOAuth2AccessToken token = wxMpService.oauth2getAccessToken(code);
            return token.getOpenId();

        } catch (WxErrorException e)
        {
            e.printStackTrace();
        }
        return null;
    }*/





}
