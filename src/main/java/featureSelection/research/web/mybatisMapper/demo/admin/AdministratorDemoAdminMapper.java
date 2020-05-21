package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.Administrator;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author jjz
 * */
@Mapper
public interface AdministratorDemoAdminMapper {
    //通过用户名查询密码
    public Administrator getAdministratorByName(String AdministratorName);
}