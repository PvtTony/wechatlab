package me.songt.wechatlab.entity;

import javax.persistence.*;

/**
 * Created by tony on 2017/5/6.
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity
{
    private int id;
    private String teacherName;
    private int teacherSchoolId;
    private String teacherPassword;

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
    @Column(name = "teacher_name", nullable = false, length = 255)
    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "teacher_school_id", nullable = false)
    public int getTeacherSchoolId()
    {
        return teacherSchoolId;
    }

    public void setTeacherSchoolId(int teacherSchoolId)
    {
        this.teacherSchoolId = teacherSchoolId;
    }

    @Basic
    @Column(name = "teacher_password", nullable = false, length = 255)
    public String getTeacherPassword()
    {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword)
    {
        this.teacherPassword = teacherPassword;
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

        TeacherEntity that = (TeacherEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (teacherSchoolId != that.teacherSchoolId)
        {
            return false;
        }
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null)
        {
            return false;
        }
        if (teacherPassword != null ? !teacherPassword.equals(that.teacherPassword) : that.teacherPassword != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + teacherSchoolId;
        result = 31 * result + (teacherPassword != null ? teacherPassword.hashCode() : 0);
        return result;
    }
}
