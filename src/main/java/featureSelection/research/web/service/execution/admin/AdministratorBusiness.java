package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;

import java.util.List;

public interface AdministratorBusiness {
    public List<Administrator> getAdministrators();

    public void updateAdministrator(Administrator administrator);

    public void deleteAdministratorById(String administratorId);

    public void addAdministrator(Administrator administrator);
}
