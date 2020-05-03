package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.AlgorithmParameterDemoAdmin;
import featureSelection.research.web.mybatisMapper.ParameterDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ParameterDemoAdmin")
@RestController
public class ParameterController {

    @Autowired
    ParameterDemoAdminMapper parameterDemoAdminMapper;

    @GetMapping("/findAll")
    public List<AlgorithmParameterDemoAdmin> findAll(){
        return parameterDemoAdminMapper.findAll();
    }
}
