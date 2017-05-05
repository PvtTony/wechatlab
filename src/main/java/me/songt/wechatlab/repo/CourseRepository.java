package me.songt.wechatlab.repo;

import me.songt.wechatlab.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tony on 2017/5/5.
 */
@Transactional
@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer>
{
    List<CourseEntity> findBycourseTeacher(int teacherId);

}
