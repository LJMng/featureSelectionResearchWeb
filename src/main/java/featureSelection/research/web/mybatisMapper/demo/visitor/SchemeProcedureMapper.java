package featureSelection.research.web.mybatisMapper.demo.visitor;


import featureSelection.research.web.entity.demo.visitor.SchemeProcedure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SchemeProcedureMapper {

    @Select("SELECT * from scheme_procedure where scheme_id=#{schemeid}")
    public List<SchemeProcedure> getSchemeProceduresBySchemeId(@Param("schemeid")int schemeid);
}
