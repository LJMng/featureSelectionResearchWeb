package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.entity.execution.admin.PageElement;
import featureSelection.research.web.mybatisMapper.execution.admin.AdministratorMapper;
import featureSelection.research.web.service.execution.admin.AdministratorBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class AdministratorBusinessImpl implements AdministratorBusiness {
    @Autowired
    private AdministratorMapper administratorMapper;
    @Override
    public List<Administrator> getAdministrators() {
        List<Administrator> administrators=administratorMapper.getAdministrator();
        return administrators;
    }

    @Override
    public String updateAdministrator(Administrator administrator) {
        if (administratorMapper.findByAdministratorId(administrator.getAdministratorId()).getAdministratorName().equals("root")){
            if (administrator.getAdministratorName().equals("root")){
                String md5DigestAsHex = DigestUtils.md5DigestAsHex(administrator.getAdministratorPassword().getBytes());
                administrator.setAdministratorPassword(md5DigestAsHex);
                administratorMapper.updateAdministrator(administrator);
                return "修改管理员信息成功！";
            }else {
                return "修改管理员信息失败，root用户只能修改密码！";
            }
        }else {
            if (administrator.getAdministratorName().equals("root")){
                return "普通账户不能修改用户名为“root”,请选择别的用户名进行修改！";
            }else{
                String md5DigestAsHex = DigestUtils.md5DigestAsHex(administrator.getAdministratorPassword().getBytes());
                administrator.setAdministratorPassword(md5DigestAsHex);
                administratorMapper.updateAdministrator(administrator);
                return "修改管理员信息成功！";
            }

        }

    }

    @Override
    public boolean deleteAdministratorByAdministratorName(String administratorName) {
        if (administratorName.equals("root")){
            return false;
        }else {
            administratorMapper.deleteAdministratorByAdministratorName(administratorName);
            return true;
        }

    }

    @Override
    public String addAdministrator(Administrator administrator) {
        //判断添加的账户是否为“root”用户
        if (administrator.getAdministratorName().equals("root")){
            return "添加失败,不能添加用户名为“root”的管理员账户！";
        }else {
            if(administrator.getAdministratorPassword().equals(administrator.getConfirmAdministratorPassword())){
                String md5DigestAsHex = DigestUtils.md5DigestAsHex(administrator.getAdministratorPassword().getBytes());
                administrator.setAdministratorPassword(md5DigestAsHex);
                administratorMapper.addAdministrator(administrator);
                return "添加管理员账户成功！";
            }else {
                return "输入密码不一致,请重新添加！";
            }
        }


    }
}
