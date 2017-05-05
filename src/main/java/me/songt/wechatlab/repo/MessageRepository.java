package me.songt.wechatlab.repo;

import me.songt.wechatlab.entity.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface MessageRepository extends PagingAndSortingRepository<MessageEntity, Integer>
{
    Page<MessageEntity> findBymessageTo(int messageTo, Pageable pageable);

    Page<MessageEntity> findBymessageFrom(int messageFrom, Pageable pageable);
}
