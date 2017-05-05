package me.songt.wechatlab.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourseEntity
{
    private int id;
    private int studentId;
    private int courseId;

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
    @Column(name = "student_id", nullable = false)
    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "course_id", nullable = false)
    public int getCourseId()
    {
        return courseId;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
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

        StudentCourseEntity that = (StudentCourseEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (studentId != that.studentId)
        {
            return false;
        }
        if (courseId != that.courseId)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + studentId;
        result = 31 * result + courseId;
        return result;
    }
}
