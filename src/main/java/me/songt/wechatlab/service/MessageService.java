package me.songt.wechatlab.service;

import me.songt.wechatlab.entity.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface MessageService
{
    Page<MessageEntity> getMessages(int userId, int index, int pageSize, boolean descent, String sortField);

    MessageEntity sendMessage(int fromUserId, int toUserId, String content);
}
