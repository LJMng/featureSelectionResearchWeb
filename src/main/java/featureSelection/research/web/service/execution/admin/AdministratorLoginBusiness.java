package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import org.springframework.stereotype.Service;

/**
 * 验证管理员登陆的接口
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
@Service
public interface AdministratorLoginBusiness {
    /**
     * 根据前端传来的管理员信息，在数据库中验证是否存在该管理员
     * @param administrator 封装管理员信息的实体类
     * @return boolean true or false
     */
    public boolean administratorLogin(Administrator administrator);
}
