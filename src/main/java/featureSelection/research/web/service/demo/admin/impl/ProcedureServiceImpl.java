package featureSelection.research.web.service.demo.admin.impl;

import featureSelection.research.web.entity.demo.admin.ProcedureSettingsDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeProcedureDemoAdmin;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import featureSelection.research.web.mybatisMapper.demo.admin.ProcedureSettingsDemoAdminMapper;
import featureSelection.research.web.mybatisMapper.demo.admin.SchemeDemoAdminMapper;
import featureSelection.research.web.mybatisMapper.demo.admin.SchemeProcedureDemoAdminMapper;
import featureSelection.research.web.service.demo.admin.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    SchemeDemoAdminMapper schemeDemoAdminMapper;

    @Autowired
    SchemeProcedureDemoAdminMapper schemeProcedureDemoAdminMapper;

    @Autowired
    ProcedureSettingsDemoAdminMapper procedureSettingsDemoAdminMapper;

    @Override
    public String insertSchemeProcedureAfterDeleteDemoAdmin(ProcedureSettings procedureSettings) {
        ProcedureSettingsDemoAdmin p = schemeProcedureDemoAdminMapper.findNewProcedureAlgorithmId();
        List<SchemeDemoAdmin> list1 = schemeDemoAdminMapper.getSchemeDemoAdminByAlgorithmId(p.getAlgorithmId());
        SchemeProcedureDemoAdmin s = new SchemeProcedureDemoAdmin();
        for(int i=0;i<list1.size();i++){
            s.setSchemeId(list1.get(i).getSchemeId());
            s.setProcedureName(procedureSettings.getName());
            schemeProcedureDemoAdminMapper.insertSchemeProcedureAfterDeleteDemoAdmin(s);
        }
        return null;
    }

    @Override
    public int updateProcedureNameAfterChangedByExecutionAdmin(ProcedureSettings procedureSettings) {
        return procedureSettingsDemoAdminMapper.updateProcedureNameAfterChangedByExecutionAdmin(procedureSettings);
    }


}
