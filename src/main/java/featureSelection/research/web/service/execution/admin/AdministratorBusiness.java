package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;

import java.util.List;

/**
 * 该接口提供了获取管理员信息，修改管理员信息，删除管理员信息，添加管理员信息的方法
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public interface AdministratorBusiness {
    /**
     * 获取数据库中管理员的所有信息，并且封装成一个List<Administrator>返回给前端页面
     * @return List<Administrator> 封装管理员信息类的线性表
     */
    public List<Administrator> getAdministrators();

    /**
     * 根据输入的管理员信息Id,在数据库中找到相应的管理员信息并进行修改
     * @param administrator 封装管理员信息的实体类
     */
    public void updateAdministrator(Administrator administrator);

    /**
     * 根据管理员的Id,在数据库中删除管理员的信息
     * @param administratorId 管理员的Id
     */
    public void deleteAdministratorById(String administratorId);

    /**
     * 添加管理员信息，根据管理员实体类，在数据库中添加管理员信息
     * @param administrator 封装管理员信息的实体类
     */
    public void addAdministrator(Administrator administrator);
}
