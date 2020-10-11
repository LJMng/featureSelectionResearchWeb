package featureSelection.research.web.mybatisMapper.execution.admin;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface ParameterValueMapper {
    @Select("select algorithm_parameter from parameter_value_map where web_parameter=#{webParameter}")
    public String findByWebParameter(String webParameter);

    @Insert("insert into parameter_value_map (web_parameter,algorithm_parameter) values (#{webParameter},#{algorithmParameter})")
    public void insert(String webParameter, String algorithmParameter);
}
