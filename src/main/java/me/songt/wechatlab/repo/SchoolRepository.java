package me.songt.wechatlab.repo;

import me.songt.wechatlab.entity.SchoolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by tony on 2017/5/5.
 */
@Transactional
@Repository
public interface SchoolRepository extends CrudRepository<SchoolEntity, Integer>
{
}
