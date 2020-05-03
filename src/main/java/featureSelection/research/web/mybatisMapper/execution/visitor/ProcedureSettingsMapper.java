package featureSelection.research.web.mybatisMapper.execution.visitor;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/26 11:03
 */
@Mapper
@Repository
public interface ProcedureSettingsMapper {

    @Select("select * from procedure_settings")
    List<Map<String, Object>> getProcedureSettingList();
}
