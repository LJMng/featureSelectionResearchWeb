package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdministratorLoginMapper {
    @Select("select * from administrator where administrator_id=#{id}")
    public Administrator findById(String id);

    @Select("select * from administrator where administrator_name=#{administratorName}")
    public Administrator findByAdministratorName(String administratorName);
}
