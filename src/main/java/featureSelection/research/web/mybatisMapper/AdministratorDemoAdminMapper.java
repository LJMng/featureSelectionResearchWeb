package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorDemoAdminMapper {
    //通过用户名查询密码
    public Administrator getAdministratorByName(String AdministratorName);
}