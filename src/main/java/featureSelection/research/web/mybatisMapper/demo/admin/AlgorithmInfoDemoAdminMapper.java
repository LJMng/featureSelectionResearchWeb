package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.AlgorithmInfoDemoAdmin;
import featureSelection.research.web.entity.execution.admin.Algorithm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AlgorithmInfoDemoAdminMapper {
    //查询所有算法信息
    public List<AlgorithmInfoDemoAdmin> findAll();
    //通过ID查询算法信息
    public AlgorithmInfoDemoAdmin getAlgorithmInfoDemoAdminById(Integer id);
    //增加算法信息
    public int insertAlgorithmInfoDemoAdmin(Algorithm algorithm);
    //增加对应的参数名称
    public int insertAlgorithmParameterDemoAdmin(Algorithm algorithm);
    //更新被绑定ID的算法信息
    public int updateAlgorithmInfoDemoAdmin(Algorithm algorithm);
    //删除被绑定ID的算法信息
    public int deleteAlgorithmInfoDemoAdmin(Integer id);
    //删除对应的算法参数
    public int deleteAlgorithmParameterDemoAdmin(Integer id);
    //查询所有算法ID和名称提供方案调用
    public List<AlgorithmInfoDemoAdmin> findAllIdAndName();
    //通过算法ID查询算法参数
    public AlgorithmInfoDemoAdmin getParameterById(Integer id);
}
