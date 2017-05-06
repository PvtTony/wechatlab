package me.songt.wechatlab.controller;

import me.chanjar.weixin.mp.api.WxMpService;
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
    public String bind(Model model)
    {
        return "bind";
    }

}
