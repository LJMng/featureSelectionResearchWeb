package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.demo.admin.AlgorithmParameterDemoAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParameterDemoAdminMapper {
    //查询所有参数信息
    public List<AlgorithmParameterDemoAdmin> findAll();
}
