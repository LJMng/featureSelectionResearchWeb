package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.mybatisMapper.execution.admin.AdministratorMapper;
import featureSelection.research.web.service.execution.admin.AdministratorBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        administratorMapper.updateAdministrator(administrator);
    }

    @Override
    public void deleteAdministratorById(String administratorId) {
        administratorMapper.deleteAdministratorById(administratorId);
    }

    @Override
    public void addAdministrator(Administrator administrator) {
        administratorMapper.addAdministrator(administrator);
    }
}
