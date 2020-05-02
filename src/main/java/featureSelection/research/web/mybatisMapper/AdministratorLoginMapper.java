package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.execution.admin.Administrator;
import org.apache.ibatis.annotations.Select;

public interface AdministratorLoginMapper {
    @Select("select * from administrator where administrator_id=#{id}")
    public Administrator findById(String id);
}
