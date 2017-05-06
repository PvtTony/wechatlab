package me.songt.wechatlab.vo;

/**
 * Created by tony on 2017/5/6.
 */
public class UserInfo
{
    private int userId;
    private String userOpenId;
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

    public String getUserOpenId()
    {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId)
    {
        this.userOpenId = userOpenId;
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
