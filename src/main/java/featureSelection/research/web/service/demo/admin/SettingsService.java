package featureSelection.research.web.service.demo.admin;

import featureSelection.research.web.entity.demo.admin.BSettingsDemoAdmin;

import java.util.List;

public interface SettingsService {
    //通过ID查询方案
    public List<BSettingsDemoAdmin> getBSettingsBySchemeId(Integer id);
}
