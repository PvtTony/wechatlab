package me.songt.wechatlab.repo;

import me.songt.wechatlab.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>
{
    UserEntity findByuserName(String userName);

    UserEntity findByuserEmail(String userEmail);
}
