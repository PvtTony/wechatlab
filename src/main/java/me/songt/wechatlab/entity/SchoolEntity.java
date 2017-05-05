package me.songt.wechatlab.entity;

import javax.persistence.*;

@Entity
@Table(name = "school")
public class SchoolEntity
{
    private int id;
    private String schoolName;

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
    @Column(name = "school_name", nullable = false, length = 255)
    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
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

        SchoolEntity that = (SchoolEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (schoolName != null ? !schoolName.equals(that.schoolName) : that.schoolName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        return result;
    }
}
