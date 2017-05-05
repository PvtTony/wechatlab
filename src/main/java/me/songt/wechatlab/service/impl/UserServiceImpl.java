package me.songt.wechatlab.service.impl;

import me.songt.wechatlab.entity.UserEntity;
import me.songt.wechatlab.repo.StudentRepository;
import me.songt.wechatlab.repo.TeacherRepository;
import me.songt.wechatlab.repo.UserRepository;
import me.songt.wechatlab.service.UserService;
import me.songt.wechatlab.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/5/6.
 */
@Service
public class UserServiceImpl implements UserService
{

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public UserInfo authenticate(String username, String password)
    {
        UserInfo info = null;
        UserEntity entity = null;
        entity = userRepository.findByuserName(username);
        if (entity == null)
        {
            entity = userRepository.findByuserEmail(username);
        }
        if (password.equals(entity.getUserPassword()))
        {
            info = new UserInfo();
            info.setUserId(entity.getId());
            info.setUserEmail(entity.getUserEmail());
            info.setUserType(entity.getUserType());
            switch (info.getUserType())
            {
                case UserEntity.USER_STUDENT:
                    info.setTypeObject(studentRepository.findOne(entity.getUserTypeId()));
                    break;
                case UserEntity.USER_TEACHER:
                    info.setTypeObject(teacherRepository.findOne(entity.getUserTypeId()));
                    break;
                case UserEntity.USER_ADMIN:
                    break;
            }
        }
        return info;
    }


}
