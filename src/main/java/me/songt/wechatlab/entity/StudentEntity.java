package me.songt.wechatlab.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity
{
    private int id;
    private String studentName;
    private int studentSchoolId;

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
    @Column(name = "student_name", nullable = false, length = 255)
    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "student_school_id", nullable = false)
    public int getStudentSchoolId()
    {
        return studentSchoolId;
    }

    public void setStudentSchoolId(int studentSchoolId)
    {
        this.studentSchoolId = studentSchoolId;
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

        StudentEntity that = (StudentEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (studentSchoolId != that.studentSchoolId)
        {
            return false;
        }
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + studentSchoolId;
        return result;
    }
}
