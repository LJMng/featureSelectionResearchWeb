package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper {
    @Select("select * from administrator")
    public List<Administrator> getAdministrator();

    @Update("update administrator set administrator_name=#{administratorName},administrator_password=#{administratorPassword}" +
            " where administrator_id=#{administratorId}")
    public void updateAdministrator(Administrator administrator);

    @Insert("insert into administrator (administrator_name,administrator_password)" +
            " values (#{administratorName},#{administratorPassword})")
    public void addAdministrator(Administrator administrator);

    @Select("select * from administrator where administrator_name = #{administratorName}")
    public Administrator findByAdministratorName(String administratorName);

    @Delete("delete from administrator where administrator_name = #{administratorName} ")
    public void deleteAdministratorByAdministratorName(String administratorName);

    @Select("select * from administrator where administrator_id = #{administratorId}")
    public Administrator findByAdministratorId(int administratorId);
}
