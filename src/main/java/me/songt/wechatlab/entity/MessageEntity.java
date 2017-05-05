package me.songt.wechatlab.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class MessageEntity
{
    private int id;
    private int messageFrom;
    private int messageTo;
    private String messageContent;
    private Timestamp messageSendTime;

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
    @Column(name = "message_from", nullable = false)
    public int getMessageFrom()
    {
        return messageFrom;
    }

    public void setMessageFrom(int messageFrom)
    {
        this.messageFrom = messageFrom;
    }

    @Basic
    @Column(name = "message_to", nullable = false)
    public int getMessageTo()
    {
        return messageTo;
    }

    public void setMessageTo(int messageTo)
    {
        this.messageTo = messageTo;
    }

    @Basic
    @Column(name = "message_content", nullable = false, length = -1)
    public String getMessageContent()
    {
        return messageContent;
    }

    public void setMessageContent(String messageContent)
    {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "message_send_time", nullable = false)
    public Timestamp getMessageSendTime()
    {
        return messageSendTime;
    }

    public void setMessageSendTime(Timestamp messageSendTime)
    {
        this.messageSendTime = messageSendTime;
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

        MessageEntity that = (MessageEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (messageFrom != that.messageFrom)
        {
            return false;
        }
        if (messageTo != that.messageTo)
        {
            return false;
        }
        if (messageContent != null ? !messageContent.equals(that.messageContent) : that.messageContent != null)
        {
            return false;
        }
        if (messageSendTime != null ? !messageSendTime.equals(that.messageSendTime) : that.messageSendTime != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + messageFrom;
        result = 31 * result + messageTo;
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (messageSendTime != null ? messageSendTime.hashCode() : 0);
        return result;
    }
}
