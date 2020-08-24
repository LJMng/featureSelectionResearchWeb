package featureSelection.research.web.service.demo.admin.impl;

import featureSelection.research.web.entity.demo.admin.DatasetDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.SchemeDemoAdminMapper;
import featureSelection.research.web.service.demo.admin.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchemeServiceImpl implements SchemeService {

    @Autowired
    SchemeDemoAdminMapper schemeDemoAdminMapper;

    @Override
    public List<SchemeDemoAdmin> findAll() {
        return schemeDemoAdminMapper.findAll();
    }

    @Override
    public SchemeDemoAdmin getSchemeDemoAdminById(Integer id) {
        return schemeDemoAdminMapper.getSchemeDemoAdminById(id);
    }

    @Override
    @Transactional
    public String insertScheme(SchemeDemoAdmin schemeDemoAdmin) {
        //将数据插入参数方案表
        schemeDemoAdminMapper.insertSchemeDemoAdmin(schemeDemoAdmin);
        //将数据插入参数方案值表
        schemeDemoAdminMapper.insertSchemeParameterSchemeIdAndParameterId(schemeDemoAdmin);
        return null;
    }

    @Override
    @Transactional
    public String updateSchemeDemoAdmin(SchemeDemoAdmin schemeDemoAdmin) {
        schemeDemoAdminMapper.updateSchemeDemoAdmin(schemeDemoAdmin);
        schemeDemoAdminMapper.updateSchemeParameterDemoAdmin(schemeDemoAdmin);
        return null;
    }

    @Override
    @Transactional
    public String deleteSchemeDemoAdmin(Integer id) {
        schemeDemoAdminMapper.deleteSchemeParameterValue(id);
        schemeDemoAdminMapper.deleteScheme(id);
        return null;
    }

    @Override
    public List<DatasetDemoAdmin> findAllIdAndName() {
        return schemeDemoAdminMapper.findAllIdAndName();
    }
}
