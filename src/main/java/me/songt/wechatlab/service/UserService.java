package me.songt.wechatlab.service;

import me.songt.wechatlab.vo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/5/6.
 */
@Service
public interface UserService
{
    UserInfo getUserByOpenId(String openId);

    UserInfo bindStudent(int studentId, String password, String openId);

    UserInfo bindTeacher(int teacherId, String password, String openId);
}
