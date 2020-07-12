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

    /**
     * 获取所有算法步骤设置信息
     * @return List<Map<String, Object>> Map对象数组，一个记录为一个Map对象，Map对象中Key为字段，Value为该字段对应的值
     */
    @Select("select * from procedure_settings")
    List<Map<String, Object>> getProcedureSettingList();
}
