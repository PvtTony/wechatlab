package me.songt.wechatlab.service.impl;

import me.songt.wechatlab.entity.MessageEntity;
import me.songt.wechatlab.repo.MessageRepository;
import me.songt.wechatlab.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private MessageRepository messageRepository;

    Sort sort;

    @Override
    public Page<MessageEntity> getMessages(int userId, int index, int pageSize, boolean descent, String sortField)
    {
        sort = new Sort(descent ? Sort.Direction.DESC : Sort.Direction.ASC, sortField);
        return messageRepository.findBymessageTo(userId, new PageRequest(index, pageSize, sort));
    }

    @Override
    public MessageEntity sendMessage(int fromUserId, int toUserId, String content)
    {
        MessageEntity entity = new MessageEntity();
        entity.setMessageFrom(fromUserId);
        entity.setMessageTo(toUserId);
        entity.setMessageContent(content);
        entity.setMessageSendTime(new Timestamp(System.currentTimeMillis()));
        return messageRepository.save(entity);
    }
}
