package featureSelection.research.web.mybatisMapper.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.Dataset;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName : DatasetMapper
 * @Description :
 * @Author : WDD
 * @Date: 2020-04-16 18:16
 */
@Repository
public interface DatasetMapper {
    public Dataset getDatasetInfo(@Param("datasetid")int datasetid);
}
