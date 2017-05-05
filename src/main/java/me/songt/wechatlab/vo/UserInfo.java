package me.songt.wechatlab.vo;

/**
 * Created by tony on 2017/5/6.
 */
public class UserInfo
{
    private int userId;
    private String userName;
    private String userEmail;
    private int userType;
    private Object typeObject;


    public UserInfo()
    {
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }

    public Object getTypeObject()
    {
        return typeObject;
    }

    public void setTypeObject(Object typeObject)
    {
        this.typeObject = typeObject;
    }
}
