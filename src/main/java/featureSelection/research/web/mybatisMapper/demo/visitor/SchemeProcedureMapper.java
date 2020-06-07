package featureSelection.research.web.mybatisMapper.demo.visitor;


import featureSelection.research.web.entity.demo.visitor.SchemeProcedure;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchemeProcedureMapper {

    public List<SchemeProcedure> getSchemeProceduresBySchemeId(@Param("schemeid")int schemeid);
}
