package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.TaskResult;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 通过算法任务的id查询所有算法结果
     * @param taskId 算法id
     * @return List<TaskResult> 算法结果对象数组
     */
    @Select("select * from task_result where task_id = #{taskId}")
    List<TaskResult> getTaskResults(int taskId);

    /**
     * 向算法结果表中插入算法任务结果
     * @param taskId 算法id
     * @param resultId 结果id
     * @param result 结果值
     */
    @Insert("insert into task_result values(#{taskId}, #{resultId}, #{result})")
    void insertTaskResults(int taskId, int resultId ,String result);

}
