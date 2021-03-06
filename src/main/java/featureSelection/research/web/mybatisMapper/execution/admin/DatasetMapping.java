package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Dataset;
import featureSelection.research.web.entity.execution.admin.DatasetForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DatasetMapping {
    @Insert("insert into dataset (dataset_name, dataset_description, dataset_records, dataset_source, dataset_dimension,dataset_file, dataset_size, dataset_tags, dataset_type) " +
            "values (#{datasetName},#{datasetDescription},#{datasetRecords},#{datasetSource},#{datasetDimension},#{datasetFile},#{datasetSize},#{datasetTags},#{datasetType})")
    public void createDataset(Dataset dataset);

    @Select("select * from dataset")
    public List<Dataset> getDatasetList();

    @Delete("delete from dataset where dataset_id=#{datasetId}")
    public void deleteDatasetById(int datasetId);

    @Update("update dataset set dataset_name=#{datasetName},dataset_description=#{datasetDescription},dataset_count=#{datasetCount},dataset_source=#{datasetSource},dataset_dimension=#{datasetDimension},is_common=#{isCommon}" +
            " where dataset_id=#{datasetId}")
    public void updateDataset(Dataset dataset);

    @Select("select * from dataset_form where input_status='审核中'")
    public List<DatasetForm> getDatasetForms();

    @Select("select * from dataset_form where input_id = #{inputId}")
    public DatasetForm getDatasetFormById(int inputId);

    @Delete("delete from dataset_form where input_id=#{inputId}")
    public void deleteDatasetFormById(int inputId);

    @Update("update dataset_form set input_status=#{inputStatus},input_end_time=#{inputEndTime}," +
            "input_reviewer=#{inputReviewer} where input_id=#{inputId}")
    public void updateDatasetForm(DatasetForm datasetForm);
}
