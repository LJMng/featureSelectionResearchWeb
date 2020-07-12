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

    /**
     * 向数据库添加数据集上传表单
     * @param datasetForm 算法表单对象
     */
    @Insert("insert into dataset_form(account_id,input_name,input_description,input_href,input_preprocess,input_algorithm,input_file,input_record,input_dimension,input_tag,input_type) " +
            "values (#{accountId},#{inputName},#{inputDescription},#{inputHref},#{inputPreprocess},#{inputAlgorithm},#{inputFile},#{inputRecord},#{inputDimension},#{inputTag},#{inputType})")
    void addDatasetForm(DatasetForm datasetForm);

    /**
     * 通过算法用户id查询该用户上传的公共数据集表单信息
     * @param accountId
     * @return List<DatasetForm> 数据集对象数组
     */
    @Select("select * from dataset_form where account_id = #{accountId}")
    List<DatasetForm> getDatasetForm(int accountId);

    /**
     * 查询数据集表单数据库中是否含有某个数据集名称
     * @param datasetName 待查询的数据集名称
     * @return 同名的数据集个数
     */
    @Select("select count(input_name) from dataset_form where input_name = #{datasetName}")
    int queryDatasetFormName(String datasetName);
}
