package featureSelection.research.web.service.demo.admin.impl;

import featureSelection.research.web.entity.demo.admin.BSettingsDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.SettingsDemoAdminMapper;
import featureSelection.research.web.service.demo.admin.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    SettingsDemoAdminMapper settingsDemoAdminMapper;

    @Override
    public List<BSettingsDemoAdmin> getBSettingsBySchemeId(Integer id) {
        return settingsDemoAdminMapper.getBSettingsBySchemeId(id);
    }
}
