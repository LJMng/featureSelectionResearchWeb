package featureSelection.research.web.service.demo.admin.impl;

import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeProcedureDemoAdmin;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import featureSelection.research.web.mybatisMapper.demo.admin.SchemeProcedureDemoAdminMapper;
import featureSelection.research.web.service.demo.admin.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    SchemeProcedureDemoAdminMapper schemeProcedureDemoAdminMapper;

    @Override
    public String insertSchemeProcedureAfterDeleteDemoAdmin(ProcedureSettings procedureSettings) {
        List<SchemeProcedureDemoAdmin> list = schemeProcedureDemoAdminMapper.findSchemeProcedureAfterDeleteSchemeId();
        SchemeProcedureDemoAdmin s = new SchemeProcedureDemoAdmin();
        for(int i=0;i<list.size();i++){
            s.setSchemeId(list.get(i).getSchemeId());
            s.setProcedureName(procedureSettings.getName());
            schemeProcedureDemoAdminMapper.insertSchemeProcedureAfterDeleteDemoAdmin(s);
        }
        return null;
    }
}
