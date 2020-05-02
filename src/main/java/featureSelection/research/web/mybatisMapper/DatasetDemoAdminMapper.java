package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.demo.admin.DatasetDemoAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DatasetDemoAdminMapper {
    //查询所有数据集信息
    public List<DatasetDemoAdmin> findAll();
    //通过ID查询数据集信息
    public DatasetDemoAdmin getDatasetDemoAdminById(Integer id);
    //增加数据集信息
    public int insertDatasetDemoAdmin(DatasetDemoAdmin datasetDemoAdmin);
    //更新被绑定ID的数据集信息
    public int updateDatasetDemoAdmin(DatasetDemoAdmin datasetDemoAdmin);
    //删除被绑定ID的数据集信息
    public int deleteDatasetDemoAdmin(Integer id);
    //删除方案对应的数据集
    public int deleteDatasetInScheme(Integer id);
    //查询所有算法ID和名称提供方案调用
    public List<DatasetDemoAdmin> findAllIdAndName();
}
