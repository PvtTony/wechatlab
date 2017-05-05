package me.songt.wechatlab.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class CourseEntity
{
    private int id;
    private String courseName;
    private String courseTime;
    private int courseRepeatType;
    private int courseTeacher;
    private String courseLocation;
    private String courseComment;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "course_time", nullable = false, length = 255)
    public String getCourseTime()
    {
        return courseTime;
    }

    public void setCourseTime(String courseTime)
    {
        this.courseTime = courseTime;
    }

    @Basic
    @Column(name = "course_repeat_type", nullable = false)
    public int getCourseRepeatType()
    {
        return courseRepeatType;
    }

    public void setCourseRepeatType(int courseRepeatType)
    {
        this.courseRepeatType = courseRepeatType;
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
        if (courseRepeatType != that.courseRepeatType)
        {
            return false;
        }
        if (courseTeacher != that.courseTeacher)
        {
            return false;
        }
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null)
        {
            return false;
        }
        if (courseTime != null ? !courseTime.equals(that.courseTime) : that.courseTime != null)
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
        result = 31 * result + (courseTime != null ? courseTime.hashCode() : 0);
        result = 31 * result + courseRepeatType;
        result = 31 * result + courseTeacher;
        result = 31 * result + (courseLocation != null ? courseLocation.hashCode() : 0);
        result = 31 * result + (courseComment != null ? courseComment.hashCode() : 0);
        return result;
    }
}
