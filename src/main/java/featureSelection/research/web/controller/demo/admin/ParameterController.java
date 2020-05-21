package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.AlgorithmParameterDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.ParameterDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author jjz
 * */
@RequestMapping("/ParameterDemoAdmin")
@RestController
public class ParameterController {

    @Autowired
    ParameterDemoAdminMapper parameterDemoAdminMapper;

    /**
     * @return 返回所有的算法参数信息，用在方案管理页面展示参数信息
     * */
    @GetMapping("/findAll")
    public List<AlgorithmParameterDemoAdmin> findAll(){
        return parameterDemoAdminMapper.findAll();
    }
}
