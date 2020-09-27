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
    public boolean updateAdministrator(Administrator administrator) {
        System.out.println(administratorMapper.findByAdministratorId(administrator.getAdministratorId()).getAdministratorName());
        System.out.println(administrator.getAdministratorName());
        if (administratorMapper.findByAdministratorId(administrator.getAdministratorId()).getAdministratorName().equals("root")){
            if (administrator.getAdministratorName().equals("root")){
                String md5DigestAsHex = DigestUtils.md5DigestAsHex(administrator.getAdministratorPassword().getBytes());
                administrator.setAdministratorPassword(md5DigestAsHex);
                administratorMapper.updateAdministrator(administrator);
                return true;
            }else {
                System.out.println("修改出错");
                return false;
            }
        }else {
            String md5DigestAsHex = DigestUtils.md5DigestAsHex(administrator.getAdministratorPassword().getBytes());
            administrator.setAdministratorPassword(md5DigestAsHex);
            administratorMapper.updateAdministrator(administrator);
            return true;
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
    public boolean addAdministrator(Administrator administrator) {
        if(administrator.getAdministratorPassword().equals(administrator.getConfirmAdministratorPassword())){
            String md5DigestAsHex = DigestUtils.md5DigestAsHex(administrator.getAdministratorPassword().getBytes());
            administrator.setAdministratorPassword(md5DigestAsHex);
            administratorMapper.addAdministrator(administrator);
            return true;
        }else {
            return false;
        }

    }
}
