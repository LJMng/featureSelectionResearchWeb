package featureSelection.research.web.controller.demo.visitor;

import featureSelection.research.web.common.util.ResultUtil;
import featureSelection.research.web.entity.Result;
import featureSelection.research.web.entity.demo.visitor.UpdateInfo;
import featureSelection.research.web.mybatisMapper.demo.visitor.UpdateMapper;
import featureSelection.research.web.service.demo.visitor.impl.IUpdateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : UpdateInfoController
 * @Description : 算法信息更新接口类
 * @Author : WDD
 * @Date: 2020-03-31 16:24
 */
@RestController
@RequestMapping(value = "/demo/visitor")
public class UpdateInfoController {
    @Autowired
    private IUpdateServiceImpl iUpdateService;

    /**
     * 根据语言种类获取更新信息
     * @param language
     * @return
     */
    @GetMapping(value = "/getAllUpdateInfoList")
    public Result getAllUpdateInfoList(@RequestParam("language") String language) {
        if (language.equals("eh")) {
            return ResultUtil.success(iUpdateService.getAllEnUpdateInfoList());
        } else if (language.equals("ch")) {
            return ResultUtil.success(iUpdateService.getAllChUpdateInfoList());
        }else {
            return ResultUtil.error(400,"please submit the type of language");
        }
    }
}
