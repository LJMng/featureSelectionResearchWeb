package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.AlgorithmInfoDemoAdmin;
import featureSelection.research.web.mybatisMapper.AlgorithmInfoDemoAdminMapper;
import featureSelection.research.web.mybatisMapper.ParameterDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/AlgorithmInfoDemoAdmin")
@RestController
public class AlgorithmInfoController {

    @Autowired
    AlgorithmInfoDemoAdminMapper algorithmInfoDemoAdminMapper;
    @Autowired
    ParameterDemoAdminMapper parameterDemoAdminMapper;

    //提供查询所有算法信息的接口
    @GetMapping("/findAll")
    public List<AlgorithmInfoDemoAdmin> findAll(){
        return algorithmInfoDemoAdminMapper.findAll();
    }

    //提供通过ID查询算法的接口
    @GetMapping("/find/{id}")
    public AlgorithmInfoDemoAdmin getAlgorithmInfoDemoAdminById(@PathVariable("id") Integer id){
        return algorithmInfoDemoAdminMapper.getAlgorithmInfoDemoAdminById(id);
    }

    //提供增加算法信息的接口
    @PostMapping("/insert")
    public String insertAlgorithmInfoDemoAdmin(@RequestBody AlgorithmInfoDemoAdmin algorithmInfoDemoAdmin){
        algorithmInfoDemoAdminMapper.insertAlgorithmInfoDemoAdmin(algorithmInfoDemoAdmin);
        algorithmInfoDemoAdminMapper.insertAlgorithmParameterDemoAdmin(algorithmInfoDemoAdmin);
        return null;
    }

    //提供更新算法信息的接口
    @PostMapping("/update")
    public String updateAlgorithmInfoDemoAdmin(@RequestBody AlgorithmInfoDemoAdmin algorithmInfoDemoAdmin){
        algorithmInfoDemoAdminMapper.updateAlgorithmInfoDemoAdmin(algorithmInfoDemoAdmin);
        return null;
    }

    //提供删除算法信息的接口
    @PostMapping("/delete/{id}")
    public String deleteAlgorithmInfoDemoAdmin(@PathVariable("id") Integer id){
        algorithmInfoDemoAdminMapper.deleteAlgorithmParameterDemoAdmin(id);
        algorithmInfoDemoAdminMapper.deleteAlgorithmInfoDemoAdmin(id);
        return null;
    }

    //查询所有算法ID和名称提供方案调用接口
    @GetMapping("/findAllIdAndName")
    public List<AlgorithmInfoDemoAdmin> findAllIdAndName(){
        return algorithmInfoDemoAdminMapper.findAllIdAndName();
    }

    //提供通过算法ID查询算法参数的接口
    @GetMapping("/findParameter/{id}")
    public AlgorithmInfoDemoAdmin getParameterById(@PathVariable("id") Integer id){
        return algorithmInfoDemoAdminMapper.getParameterById(id);
    }
}
