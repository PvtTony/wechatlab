package me.songt.wechatlab.entity;

import javax.persistence.*;


@Entity
@Table(name = "user")
public class UserEntity
{
    private int id;
    private String userName;
    private String userPassword;
    private int userType;
    private int userTypeId;
    private String userEmail;

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
    @Column(name = "user_name", nullable = false, length = 255)
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 255)
    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
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

    @Basic
    @Column(name = "user_email", nullable = false, length = 255)
    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
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
        if (userName != null ? !userName.equals(that.userName) : that.userName != null)
        {
            return false;
        }
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null)
        {
            return false;
        }
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + userType;
        result = 31 * result + userTypeId;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        return result;
    }
}
