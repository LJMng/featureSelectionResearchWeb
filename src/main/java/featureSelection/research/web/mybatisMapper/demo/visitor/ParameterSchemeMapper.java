package featureSelection.research.web.mybatisMapper.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.ParameterScheme;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterSchemeMapper {
    public List<ParameterScheme>getAllSchemeWithParameterValue();

    public ParameterScheme getSchemeWithParameterValueById(@Param("schemeid") int schemeid);

    public ParameterScheme getSchemeWithParameterValueAndDatasetById(@Param("schemeid") int schemeid);

    public ParameterScheme getDataSetAndSchemeBySchemeId(@Param("schemeid")int schemeid);
}
