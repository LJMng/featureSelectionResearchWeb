package featureSelection.research.web.controller.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.UpdateInfo;
import featureSelection.research.web.mybatisMapper.demo.visitor.UpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName : UpdateInfoController
 * @Description : 算法信息更新接口类
 * @Author : WDD
 * @Date: 2020-03-31 16:24
 */
@Controller
public class UpdateInfoController {
    @Autowired
    private UpdateMapper updateMapper;
    @ResponseBody
    @GetMapping(value = "/getAllUpdateInfoList")
    public List<UpdateInfo> getAllUpdateInfoList(){
        return updateMapper.getAllUpdateInfoList();
    }
}
