package me.songt.wechatlab.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController
{


    @Autowired
    private WxMpService wxMpService;

    @RequestMapping("/")
    public String index(Model model)
    {
        return "index";
    }

    @GetMapping("/bind")
    public String bind(String code, String state, Model model)
    {
        try
        {
            WxMpOAuth2AccessToken token = wxMpService.oauth2getAccessToken(code);
            model.addAttribute("openid", token.getOpenId());

        } catch (WxErrorException e)
        {
            e.printStackTrace();
        }
        return "bind";
    }

}
