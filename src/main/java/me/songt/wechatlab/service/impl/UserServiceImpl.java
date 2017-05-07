package me.songt.wechatlab.service.impl;

import me.songt.wechatlab.entity.StudentEntity;
import me.songt.wechatlab.entity.TeacherEntity;
import me.songt.wechatlab.entity.UserEntity;
import me.songt.wechatlab.repo.StudentRepository;
import me.songt.wechatlab.repo.TeacherRepository;
import me.songt.wechatlab.repo.UserRepository;
import me.songt.wechatlab.service.UserService;
import me.songt.wechatlab.vo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /*@Override
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
            info.setUserEmail(entity.getUserOpenId());
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
    }*/

    @Override
    public UserInfo getUserByOpenId(String openId)
    {
        UserInfo info = new UserInfo();
        UserEntity entity = userRepository.findByuserOpenId(openId);
        if (entity == null)
        {
            return null;
        }

        info.setUserId(entity.getId());
        info.setUserOpenId(openId);
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
        return info;
    }

    @Override
    public UserInfo bindStudent(int studentId, String openId, String password)
    {
        logger.info(openId);
        StudentEntity stuEntity = studentRepository.findOne(studentId);

        if (stuEntity == null && password.equals(stuEntity.getStudentPassword()))
        {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setUserOpenId(openId);
        entity.setUserType(UserEntity.USER_STUDENT);
        entity.setUserTypeId(studentId);
        entity = userRepository.save(entity);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserType(UserEntity.USER_STUDENT);
        userInfo.setTypeObject(stuEntity);
        userInfo.setUserOpenId(openId);
        userInfo.setUserId(entity.getId());
        return userInfo;
    }

    @Override
    public UserInfo bindTeacher(int teacherId, String password, String openId)
    {
        logger.info(openId);
        UserEntity entity = new UserEntity();
        entity.setUserOpenId(openId);
        entity.setUserType(UserEntity.USER_STUDENT);
        entity.setUserTypeId(teacherId);
        entity = userRepository.save(entity);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(entity.getId());
        userInfo.setUserType(UserEntity.USER_TEACHER);
        userInfo.setUserOpenId(openId);
        TeacherEntity teacherEntity = teacherRepository.findOne(teacherId);
        if (teacherEntity == null && password.equals(teacherEntity.getTeacherPassword()))
        {
            return null;
        }
        userInfo.setTypeObject(teacherEntity);
        return userInfo;
    }


}
