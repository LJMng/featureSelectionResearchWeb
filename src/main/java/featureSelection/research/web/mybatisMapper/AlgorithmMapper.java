package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AlgorithmMapper {
    @Select("select * from algorithm")
    public List<Algorithm> getAlgorithms();
}
