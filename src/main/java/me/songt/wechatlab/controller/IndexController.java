package me.songt.wechatlab.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController
{

    @Autowired
    private WxMpService wxMpService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(Model model)
    {
        return "index";
    }

    @GetMapping("/bind")
    public String bind(@RequestParam String code, @RequestParam String state, Model model)
    {
        try
        {
            WxMpOAuth2AccessToken token = wxMpService.oauth2getAccessToken(code);
            model.addAttribute("openid", token.getOpenId());
            logger.info("OpenID: " + token.getOpenId());

        } catch (WxErrorException e)
        {
            e.printStackTrace();
        }
        return "bind";
    }

}
