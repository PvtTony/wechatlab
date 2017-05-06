package me.songt.wechatlab.entity;

import javax.persistence.*;

/**
 * Created by tony on 2017/5/6.
 */
@Entity
@Table(name = "course")
public class CourseEntity
{
    private int id;
    private String courseName;
    private int courseTeacher;
    private String courseLocation;
    private String courseComment;
    private int courseStartTime;
    private int courseEndTime;
    private int courseWeekday;

    @Id
    @Column(name = "id", nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "course_name", nullable = false, length = 255)
    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_teacher", nullable = false)
    public int getCourseTeacher()
    {
        return courseTeacher;
    }

    public void setCourseTeacher(int courseTeacher)
    {
        this.courseTeacher = courseTeacher;
    }

    @Basic
    @Column(name = "course_location", nullable = false, length = 255)
    public String getCourseLocation()
    {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation)
    {
        this.courseLocation = courseLocation;
    }

    @Basic
    @Column(name = "course_comment", nullable = true, length = -1)
    public String getCourseComment()
    {
        return courseComment;
    }

    public void setCourseComment(String courseComment)
    {
        this.courseComment = courseComment;
    }

    @Basic
    @Column(name = "course_start_time", nullable = false)
    public int getCourseStartTime()
    {
        return courseStartTime;
    }

    public void setCourseStartTime(int courseStartTime)
    {
        this.courseStartTime = courseStartTime;
    }

    @Basic
    @Column(name = "course_end_time", nullable = false)
    public int getCourseEndTime()
    {
        return courseEndTime;
    }

    public void setCourseEndTime(int courseEndTime)
    {
        this.courseEndTime = courseEndTime;
    }

    @Basic
    @Column(name = "course_weekday", nullable = false)
    public int getCourseWeekday()
    {
        return courseWeekday;
    }

    public void setCourseWeekday(int courseWeekday)
    {
        this.courseWeekday = courseWeekday;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        CourseEntity that = (CourseEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (courseTeacher != that.courseTeacher)
        {
            return false;
        }
        if (courseStartTime != that.courseStartTime)
        {
            return false;
        }
        if (courseEndTime != that.courseEndTime)
        {
            return false;
        }
        if (courseWeekday != that.courseWeekday)
        {
            return false;
        }
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null)
        {
            return false;
        }
        if (courseLocation != null ? !courseLocation.equals(that.courseLocation) : that.courseLocation != null)
        {
            return false;
        }
        if (courseComment != null ? !courseComment.equals(that.courseComment) : that.courseComment != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + courseTeacher;
        result = 31 * result + (courseLocation != null ? courseLocation.hashCode() : 0);
        result = 31 * result + (courseComment != null ? courseComment.hashCode() : 0);
        result = 31 * result + courseStartTime;
        result = 31 * result + courseEndTime;
        result = 31 * result + courseWeekday;
        return result;
    }
}
