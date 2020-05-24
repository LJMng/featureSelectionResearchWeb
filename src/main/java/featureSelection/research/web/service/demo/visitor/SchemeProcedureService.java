package featureSelection.research.web.service.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.SchemeProcedure;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName : SchemeProcedureService
 * @Description :
 * @Author : WDD
 * @Date: 2020-05-24 15:29
 */
public interface SchemeProcedureService {
    public List<SchemeProcedure> getSchemeProceduresBySchemeId(int schemeid);
}
