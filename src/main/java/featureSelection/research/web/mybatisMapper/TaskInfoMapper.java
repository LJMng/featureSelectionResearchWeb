package featureselection.research.web.mybatisMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskInfoMapper {

    @Select("select state from task_info where queue_number = #{number}")
    public String getState(String number);
}
