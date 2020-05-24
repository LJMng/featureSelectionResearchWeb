package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.entity.demo.visitor.SchemeProcedure;
import featureSelection.research.web.mybatisMapper.demo.visitor.SchemeProcedureMapper;
import featureSelection.research.web.service.demo.visitor.SchemeProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : SchemeProcedureServiceImpl
 * @Description :
 * @Author : WDD
 * @Date: 2020-05-24 15:30
 */
@Service
public class SchemeProcedureServiceImpl implements SchemeProcedureService {

    @Autowired private SchemeProcedureMapper schemeProcedureMapper;

    @Override
    public List<SchemeProcedure> getSchemeProceduresBySchemeId(int schemeid) {
        return schemeProcedureMapper.getSchemeProceduresBySchemeId(schemeid);
    }
}
