package me.songt.wechatlab.repo;

import me.songt.wechatlab.entity.StudentCourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tony on 2017/5/5.
 */
@Transactional
@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourseEntity, Integer>
{
    List<StudentCourseEntity> findBystudentId(int studentId);

    List<StudentCourseEntity> findBycourseId(int courseId);
}
