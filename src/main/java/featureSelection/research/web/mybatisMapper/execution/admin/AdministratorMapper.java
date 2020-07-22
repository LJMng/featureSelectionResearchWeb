package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdministratorMapper {
    @Select("select * from administrator")
    public List<Administrator> getAdministrator();

    @Update("update administrator set administrator_name=#{administratorName},administrator_password=#{administratorPassword}" +
            " where administrator_id=#{administratorId}")
    public void updateAdministrator(Administrator administrator);

    @Delete("delete from administrator where administrator_id=#{administratorId}")
    public void deleteAdministratorById(String administratorId);

    @Insert("insert into administrator (administrator_name,administrator_password)" +
            " values (#{administratorName},#{administratorPassword})")
    public void addAdministrator(Administrator administrator);


}
