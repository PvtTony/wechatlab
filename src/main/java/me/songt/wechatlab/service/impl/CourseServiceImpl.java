package me.songt.wechatlab.service.impl;

import me.songt.wechatlab.entity.CourseEntity;
import me.songt.wechatlab.entity.StudentCourseEntity;
import me.songt.wechatlab.repo.CourseRepository;
import me.songt.wechatlab.repo.StudentCourseRepository;
import me.songt.wechatlab.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public List<CourseEntity> studentGetCourses(int studentId)
    {
        List<StudentCourseEntity> result = studentCourseRepository.findBystudentId(studentId);
        List<CourseEntity> returnList = new ArrayList<>();
        for (StudentCourseEntity entity :
                result)
        {
            returnList.add(courseRepository.findOne(entity.getCourseId()));
        }
        return returnList;
    }

    @Override
    public List<CourseEntity> teacherGetCourses(int teacherId)
    {

        return courseRepository.findBycourseTeacher(teacherId);
    }

    @Override
    public CourseEntity addCourse(CourseEntity courseEntity)
    {
        return courseRepository.save(courseEntity);
    }

    @Override
    public CourseEntity editCourse(int oldCourseId, CourseEntity newCourse)
    {
        CourseEntity old = courseRepository.findOne(oldCourseId);
        old.setCourseName(newCourse.getCourseName());
        old.setCourseComment(newCourse.getCourseComment());
        old.setCourseLocation(newCourse.getCourseLocation());
        old.setCourseStartTime(newCourse.getCourseStartTime());
        old.setCourseEndTime(newCourse.getCourseEndTime());
        old.setCourseWeekday(newCourse.getCourseWeekday());
        old.setCourseTeacher(newCourse.getCourseTeacher());
//        old.setCourseTime(newCourse.getCourseTime());
        old = courseRepository.save(old);
        return old;
    }

    @Override
    public void removeCourse(int courseId)
    {
        courseRepository.delete(courseId);
    }

    @Override
    public void removeCourse(CourseEntity courseEntity)
    {
        courseRepository.delete(courseEntity);
    }
}
