package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.TaskResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/28 15:54
 */
@Mapper
@Repository
public interface TaskResultMapper {

    @Select("select * from task_result where task_id = #{taskId}")
    List<TaskResult> getTaskResults(int taskId);
}
