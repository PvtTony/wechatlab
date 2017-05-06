package me.songt.wechatlab.controller.rest;

import me.songt.wechatlab.entity.MessageEntity;
import me.songt.wechatlab.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController
{
    @Autowired
    private MessageService messageService;

    /**
     * Get Messages by the receiver's userId
     *
     * @param userID    receiver's userId
     * @param index     page index
     * @param pageSize  how many columns in one page
     * @param descent   descent sort or ascent sort
     * @param sortField sort field eg. messageSendTime
     * @return Messages with paging info.
     */
    @GetMapping("/api/message/{userId}")
    public Page<MessageEntity> getMessages(@PathVariable("userId") int userID,
                                           @RequestParam(defaultValue = "1") int index,
                                           @RequestParam(defaultValue = "15") int pageSize,
                                           @RequestParam(defaultValue = "1") int descent,
                                           @RequestParam(defaultValue = "messageSendTime") String sortField)
    {
        return messageService.getMessages(userID, index, pageSize, descent == 1, sortField);
    }

    /**
     * Send Message
     *
     * @param userId  sender's userId
     * @param to      receiver's userId
     * @param content message Content
     * @return sent Message Info
     */
    @PostMapping("/api/message/{userId}")
    public MessageEntity sendMessage(@PathVariable("userId") int userId,
                                     @RequestParam int to,
                                     @RequestParam String content)
    {
        return messageService.sendMessage(userId, to, content);
    }

    @PostMapping("/api/message/course/{courseId}")
    public boolean sendMessageToCourseStudents(@PathVariable("courseId") int courseId, @RequestParam String content)
    {
        messageService.sendMessageToStudent(courseId, content);
        return true;
    }


}
