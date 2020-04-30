package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.DatasetDemoAdmin;
import featureSelection.research.web.mybatisMapper.DatasetDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/DatasetDemoAdmin")
@RestController
public class DatasetController {

    @Autowired
    DatasetDemoAdminMapper datasetDemoAdminMapper;

    //提供查询所有数据集信息的接口
    @GetMapping("/findAll")
    public List<DatasetDemoAdmin> findAll(){
        return datasetDemoAdminMapper.findAll();
    }

    //提供通过ID查询数据集信息的接口
    @GetMapping("/find/{id}")
    public DatasetDemoAdmin getDatasetDemoAdminById(@PathVariable("id") Integer id){
        return datasetDemoAdminMapper.getDatasetDemoAdminById(id);
    }

    //提供增加接口信息的接口
    @PostMapping("/insert")
    public String insertDatasetDemoAdmin(@RequestBody DatasetDemoAdmin datasetDemoAdmin){
        datasetDemoAdminMapper.insertDatasetDemoAdmin(datasetDemoAdmin);
        return null;
    }

    //提供更新数据集信息的接口
    @PostMapping("/update")
    public String updateDatasetDemoAdmin(@RequestBody DatasetDemoAdmin datasetDemoAdmin){
        datasetDemoAdminMapper.updateDatasetDemoAdmin(datasetDemoAdmin);
        return null;
    }

    //提供删除数据集信息的接口
    @PostMapping("/delete/{id}")
    public String deleteDatasetDemoAdmin(@PathVariable("id") Integer id){
        datasetDemoAdminMapper.deleteDatasetInScheme(id);
        datasetDemoAdminMapper.deleteDatasetDemoAdmin(id);
        return null;
    }

    //查询所有数据集ID和名称提供方案调用接口
    @GetMapping("/findAllIdAndName")
    public List<DatasetDemoAdmin> findAllIdAndName(){
        return datasetDemoAdminMapper.findAllIdAndName();
    }
}
