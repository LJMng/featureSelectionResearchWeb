package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.demo.admin.AlgorithmInfoDemoAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlgorithmInfoDemoAdminMapper {
    //查询所有算法信息
    public List<AlgorithmInfoDemoAdmin> findAll();
    //通过ID查询算法信息
    public AlgorithmInfoDemoAdmin getAlgorithmInfoDemoAdminById(Integer id);
    //增加算法信息
    public int insertAlgorithmInfoDemoAdmin(AlgorithmInfoDemoAdmin algorithmInfoDemoAdmin);
    //增加对应的参数名称
    public int insertAlgorithmParameterDemoAdmin(AlgorithmInfoDemoAdmin algorithmInfoDemoAdmin);
    //更新被绑定ID的算法信息
    public int updateAlgorithmInfoDemoAdmin(AlgorithmInfoDemoAdmin algorithmInfoDemoAdmin);
    //删除被绑定ID的算法信息
    public int deleteAlgorithmInfoDemoAdmin(Integer id);
    //删除对应的算法参数
    public int deleteAlgorithmParameterDemoAdmin(Integer id);
    //查询所有算法ID和名称提供方案调用
    public List<AlgorithmInfoDemoAdmin> findAllIdAndName();
    //通过算法ID查询算法参数
    public AlgorithmInfoDemoAdmin getParameterById(Integer id);
}
