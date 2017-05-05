package me.songt.wechatlab.service;

import me.songt.wechatlab.entity.CourseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService
{
    List<CourseEntity> studentGetCourses(int studentId);

    List<CourseEntity> teacherGetCourses(int teacherId);

    CourseEntity addCourse(CourseEntity courseEntity);

    CourseEntity editCourse(int oldCourseId, CourseEntity newCourse);

    void removeCourse(int courseId);

    void removeCourse(CourseEntity courseEntity);
}
