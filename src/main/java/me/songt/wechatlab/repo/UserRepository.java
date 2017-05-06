package me.songt.wechatlab.repo;

import me.songt.wechatlab.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>
{
    UserEntity findByuserOpenId(String userName);

//    UserEntity findByuserEmail(String userEmail);

    UserEntity findByuserTypeId(int typeId);
}
