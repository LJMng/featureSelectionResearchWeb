package featureSelection.research.web.service.demo.admin;

import featureSelection.research.web.entity.execution.admin.ProcedureSettings;

public interface ProcedureService {
    public String insertSchemeProcedureAfterDeleteDemoAdmin(ProcedureSettings procedureSettings);
    public int updateProcedureNameAfterChangedByExecutionAdmin(ProcedureSettings procedureSettings);
}
