package me.songt.wechatlab.repo;

import me.songt.wechatlab.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by tony on 2017/5/5.
 */
@Transactional
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer>
{
}
