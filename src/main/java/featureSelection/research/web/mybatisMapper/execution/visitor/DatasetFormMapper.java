package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.DatasetForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/28 15:50
 */
@Mapper
@Repository
public interface DatasetFormMapper {

    @Insert("insert into dataset_form(account_id,input_name,input_description,input_href,input_preprocess,input_algorithm,input_file,input_record,input_dimension,input_tag,input_type) " +
            "values (#{accountId},#{inputName},#{inputDescription},#{inputHref},#{inputPreprocess},#{inputAlgorithm},#{inputFile},#{inputRecord},#{inputDimension},#{inputTag},#{inputType})")
    void addDatasetForm(DatasetForm datasetForm);

    @Select("select * from dataset_form where account_id = #{accountId}")
    List<DatasetForm> getDatasetForm(int accountId);

    @Select("select count(input_name) from dataset_form where input_name = #{datasetName}")
    int queryDatasetFormName(String datasetName);
}
