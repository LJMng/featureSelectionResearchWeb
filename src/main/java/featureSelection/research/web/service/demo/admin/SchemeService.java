package featureSelection.research.web.service.demo.admin;

import featureSelection.research.web.entity.demo.admin.DatasetDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SchemeService {
    public List<SchemeDemoAdmin> findAll();
    public SchemeDemoAdmin getSchemeDemoAdminById(Integer id);
    public String insertScheme(SchemeDemoAdmin schemeDemoAdmin);
    public String updateSchemeDemoAdmin(SchemeDemoAdmin schemeDemoAdmin);
    public String deleteSchemeDemoAdmin(Integer id);
    public List<DatasetDemoAdmin> findAllIdAndName();
}
