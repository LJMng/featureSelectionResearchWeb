package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.UpdateInfoDemoAdmin;
import featureSelection.research.web.service.demo.admin.impl.UpdateInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jjz
 * @create 2020-07-19 9:15
 **/
@RequestMapping("/UpdateInfoDemoAdmin")
@Controller
public class UpdateInfoController {

    @Autowired
    UpdateInfoServiceImpl updateInfoService;

    /**
     * @return 返回查找到的所有更新的信息，返回格式为json
     * */
    //提供查询所有算法信息的接口
    @GetMapping("/findAll")
    public List<UpdateInfoDemoAdmin> findAll(){
        return updateInfoService.findAll();
    }

    /**
     * @param id
     *      前端点击的按钮都会对应一个id，返回的id就能用来查找
     * @return 返回通过ID查找到的更新的信息，返回格式为json
     * */
    //提供通过ID查询更新信息的接口
    @GetMapping("/find/{id}")
    public UpdateInfoDemoAdmin getUpdateInfoDemoAdminById(@PathVariable("id") Integer id){
        return updateInfoService.getUpdateInfoDemoAdminById(id);
    }

    /**
     * @param updateInfoDemoAdmin
     *      能接受更新信息类里面的字段的信息
     * @return 返回空值
     * */
    //提供增加算法信息的接口
    @PostMapping("/insert")
    public String insertUpdateInfoDemoAdmin(@RequestBody UpdateInfoDemoAdmin updateInfoDemoAdmin){
        updateInfoService.insertUpdateInfoDemoAdmin(updateInfoDemoAdmin);
        return null;
    }

    /**
     * @param updateInfoDemoAdmin
     *      能接受更新信息类里面的字段的信息
     * @return 返回空值
     * */
    //提供更新算法信息的接口
    @PostMapping("/update")
    public String updateUpdateInfoDemoAdmin(@RequestBody UpdateInfoDemoAdmin updateInfoDemoAdmin){
        updateInfoService.updateUpdateInfoDemoAdmin(updateInfoDemoAdmin);
        return null;
    }

    /**
     * @param id
     *      前端点击的按钮都会对应一个id，返回的id就能用来查找
     * @return 返回空值
     * */
    //提供删除更新信息的接口
    @PostMapping("/delete/{id}")
    public String deleteAlgorithmInfoDemoAdmin(@PathVariable("id") Integer id){
        updateInfoService.deleteUpdateInfoDemoAdmin(id);
        return null;
    }
}
