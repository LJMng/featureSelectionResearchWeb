package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Administrator;
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
    public void updateAdministrator(Administrator administrator) {
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(administrator.getAdministratorPassword().getBytes());
        administrator.setAdministratorPassword(md5DigestAsHex);
        administratorMapper.updateAdministrator(administrator);
    }

    @Override
    public void deleteAdministratorById(String administratorId) {
        administratorMapper.deleteAdministratorById(administratorId);
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
