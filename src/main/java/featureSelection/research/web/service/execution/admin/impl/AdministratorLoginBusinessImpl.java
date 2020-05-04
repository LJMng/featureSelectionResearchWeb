package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.mybatisMapper.execution.admin.AdministratorLoginMapper;
import featureSelection.research.web.service.execution.admin.AdministratorLoginBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorLoginBusinessImpl implements AdministratorLoginBusiness {
    @Autowired
    private AdministratorLoginMapper administratorLoginMapper;
    @Override
    public boolean administratorLogin(Administrator administrator) {
        Administrator administrator1=
        administratorLoginMapper.findById(administrator.getAdministratorId());
        if (administrator1.getAdministratorPassword()
                .equals(administrator.getAdministratorPassword())){
            System.out.println(administrator1);
            return true;
        }else {
            return false;
        }
    }
}
