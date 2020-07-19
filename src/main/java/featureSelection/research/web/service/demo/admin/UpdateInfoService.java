package featureSelection.research.web.service.demo.admin;

import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.entity.demo.admin.UpdateInfoDemoAdmin;

import java.util.List;

/**
 * @author jjz
 * @create 2020-07-19 9:06
 **/
public interface UpdateInfoService {
    public List<UpdateInfoDemoAdmin> findAll();
    public UpdateInfoDemoAdmin getUpdateInfoDemoAdminById(Integer id);
    public String insertUpdateInfoDemoAdmin(UpdateInfoDemoAdmin updateInfoDemoAdmin);
    public String deleteUpdateInfoDemoAdmin(Integer id);
    public String updateUpdateInfoDemoAdmin(UpdateInfoDemoAdmin updateInfoDemoAdmin);
}
