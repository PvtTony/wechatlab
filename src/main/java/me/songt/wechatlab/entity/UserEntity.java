package me.songt.wechatlab.entity;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class UserEntity
{
    private int id;
    private String userOpenId;
    private int userType;
    private int userTypeId;

    public static final int USER_STUDENT = 832;
    public static final int USER_TEACHER = 608;
    public static final int USER_ADMIN = 447;

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
    @Column(name = "user_openid", nullable = false, length = 255)
    public String getUserOpenId()
    {
        return userOpenId;
    }

    public void setUserOpenId(String userName)
    {
        this.userOpenId = userName;
    }

    @Basic
    @Column(name = "user_type", nullable = false)
    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }

    @Basic
    @Column(name = "user_type_id", nullable = false)
    public int getUserTypeId()
    {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId)
    {
        this.userTypeId = userTypeId;
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

        UserEntity that = (UserEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (userType != that.userType)
        {
            return false;
        }
        if (userTypeId != that.userTypeId)
        {
            return false;
        }
        if (userOpenId != null ? !userOpenId.equals(that.userOpenId) : that.userOpenId != null)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (userOpenId != null ? userOpenId.hashCode() : 0);
        result = 31 * result + userType;
        result = 31 * result + userTypeId;
        return result;
    }
}
