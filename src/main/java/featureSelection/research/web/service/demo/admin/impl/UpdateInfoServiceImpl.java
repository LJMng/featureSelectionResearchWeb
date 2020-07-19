package featureSelection.research.web.service.demo.admin.impl;

import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.entity.demo.admin.UpdateInfoDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.UpdateInfoDemoAdminMapper;
import featureSelection.research.web.service.demo.admin.UpdateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jjz
 * @create 2020-07-19 9:08
 **/
@Service
public class UpdateInfoServiceImpl implements UpdateInfo {
    @Autowired
    UpdateInfoDemoAdminMapper updateInfoDemoAdminMapper;

    @Override
    public List<UpdateInfoDemoAdmin> findAll() {
        return updateInfoDemoAdminMapper.findAll();
    }

    @Override
    public UpdateInfoDemoAdmin getUpdateInfoDemoAdminById(Integer id) {
        return updateInfoDemoAdminMapper.getUpdateInfoDemoAdminById(id);
    }

    @Override
    public String insertUpdateInfoDemoAdmin(UpdateInfoDemoAdmin updateInfoDemoAdmin) {
        updateInfoDemoAdminMapper.insertUpdateInfoDemoAdmin(updateInfoDemoAdmin);
        return null;
    }

    @Override
    public String deleteUpdateInfoDemoAdmin(Integer id) {
        updateInfoDemoAdminMapper.deleteUpdateInfoDemoAdmin(id);
        return null;
    }

    @Override
    public String updateUpdateInfoDemoAdmin(UpdateInfoDemoAdmin updateInfoDemoAdmin) {
        updateInfoDemoAdminMapper.updateUpdateInfoDemoAdmin(updateInfoDemoAdmin);
        return null;
    }
}
