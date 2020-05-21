package featureSelection.research.web.controller.demo.admin;


import featureSelection.research.web.entity.demo.admin.AlgorithmInfoDemoAdmin;
import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.mybatisMapper.demo.admin.AlgorithmInfoDemoAdminMapper;
import featureSelection.research.web.mybatisMapper.demo.admin.ParameterDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jjz
 * */
@RequestMapping("/AlgorithmInfoDemoAdmin")
@RestController
public class AlgorithmInfoController {

    @Autowired
    private AlgorithmInfoDemoAdminMapper algorithmInfoDemoAdminMapper;

    /**
     * @return 返回查找到的所有算法的信息，返回格式为json
     * */
    //提供查询所有算法信息的接口
    @GetMapping("/findAll")
    public List<AlgorithmInfoDemoAdmin> findAll(){
        return algorithmInfoDemoAdminMapper.findAll();
    }

    /**
     * @param id
     *      前端点击的按钮都会对应一个id，返回的id就能用来查找
     * @return 返回通过ID查找到的算法的信息，返回格式为json
     * */
    //提供通过ID查询算法的接口
    @GetMapping("/find/{id}")
    public AlgorithmInfoDemoAdmin getAlgorithmInfoDemoAdminById(@PathVariable("id") Integer id){
        return algorithmInfoDemoAdminMapper.getAlgorithmInfoDemoAdminById(id);
    }

    /**
     * @param algorithm
     *      能接受算法类里面的字段的信息
     * @return 返回空值
     * */
    //提供增加算法信息的接口
    @PostMapping("/insert")
    public String insertAlgorithmInfoDemoAdmin(@RequestBody Algorithm algorithm){
        algorithmInfoDemoAdminMapper.insertAlgorithmInfoDemoAdmin(algorithm);
        return null;
    }

    /**
     * @param algorithm
     *      能接受算法类里面的字段的信息
     * @return 返回空值
     * */
    //提供更新算法信息的接口
    @PostMapping("/update")
    public String updateAlgorithmInfoDemoAdmin(@RequestBody Algorithm algorithm){
        algorithmInfoDemoAdminMapper.updateAlgorithmInfoDemoAdmin(algorithm);
        return null;
    }

    /**
     * @param id
     *      前端点击的按钮都会对应一个id，返回的id就能用来查找
     * @return 返回空值
     * */
    //提供删除算法信息的接口
    @PostMapping("/delete/{id}")
    public String deleteAlgorithmInfoDemoAdmin(@PathVariable("id") Integer id){
        algorithmInfoDemoAdminMapper.deleteAlgorithmParameterDemoAdmin(id);
        algorithmInfoDemoAdminMapper.deleteAlgorithmInfoDemoAdmin(id);
        return null;
    }

    /**
     * @return 返回查询到的算法的ID跟名称，用来前端下拉列表选择，返回格式为json
     * */
    //查询所有算法ID和名称提供方案调用接口
    @GetMapping("/findAllIdAndName")
    public List<AlgorithmInfoDemoAdmin> findAllIdAndName(){
        return algorithmInfoDemoAdminMapper.findAllIdAndName();
    }

    /**
     * @param id
     *      前端点击的按钮都会对应一个id，返回的id就能用来查找
     * @return 返回通过ID查找到的算法参数的信息，返回格式为json
     * */
    //提供通过算法ID查询算法参数的接口
    @GetMapping("/findParameter/{id}")
    public AlgorithmInfoDemoAdmin getParameterById(@PathVariable("id") Integer id){
        return algorithmInfoDemoAdminMapper.getParameterById(id);
    }
}
