package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.entity.execution.admin.AvailableDataset4Algorithm;
import featureSelection.research.web.entity.execution.admin.Parameter;
import featureSelection.research.web.entity.execution.admin.WebAlgorithmMapperEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AlgorithmMapper {
    @Select("select * from algorithm")
    public List<Algorithm> getAlgorithms();

    @Insert("insert into parameter (algorithm_id,parameter_name,parameter_name_mapper,parameter_description,parameter_type,parameter_default_value,parameter_setting_info)" +
            " values (#{algorithmId},#{parameterName},#{parameterNameMapper},#{parameterDescription},#{parameterType},#{parameterDefaultValue},#{parameterSettingInfo})")
    public void createParameter(Parameter parameter);

    @Update("update algorithm set available_datasets = #{availableDatasets} where algorithm_id=#{algorithmId}")
    public void setAvailableDataset4Algorithm(AvailableDataset4Algorithm availableDataset4Algorithm);

    @Select("select algorithm_id from algorithm where algorithm_name=#{algorithmName}")
    public Integer getAlgorithmIdByName(String algorithmName);

    @Select("select parameter_id from parameter where parameter_name = #{parameterName}")
    public Integer getParameterIdByName(String parameterName);

    @Select("select available_datasets from algorithm where algorithm_id = #{algorithmId}")
    public String getAvailableDatasetByAlgorithmId(int algorithmId);

    @Select("select parameter_id from parameter where parameter_name = #{parameterName} and algorithm_id = #{algorithmId}")
    public int getParameterIdByNameAndAlgorithmId(String parameterName,int algorithmId);

    @Select("select * from algorithm where algorithm_name = #{algorithmName}")
    public Algorithm getAlgorithmByName(String algorithmName);

    @Select("select * from algorithm where algorithm_id = #{algorithmId}")
    public Algorithm getAlgorithmById(Integer algorithmId);
}
