package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorLoginBusiness {
    public boolean administratorLogin(Administrator administrator);
}
