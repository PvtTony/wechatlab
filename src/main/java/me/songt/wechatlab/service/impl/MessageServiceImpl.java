package me.songt.wechatlab.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.songt.wechatlab.entity.MessageEntity;
import me.songt.wechatlab.repo.MessageRepository;
import me.songt.wechatlab.repo.UserRepository;
import me.songt.wechatlab.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    private WxMpService wxMpService;
    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

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
        String toUserOpenId = userRepository.findOne(toUserId).getUserOpenId();
        WxMpKefuMessage remindInfo = WxMpKefuMessage.TEXT()
                .toUser(toUserOpenId)
                .content(content)
                .build();
        try
        {
            wxMpService.getKefuService().sendKefuMessage(remindInfo);
        } catch (WxErrorException e)
        {
            e.printStackTrace();
        }
        return messageRepository.save(entity);

    }
}
