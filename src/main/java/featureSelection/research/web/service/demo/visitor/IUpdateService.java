package featureSelection.research.web.service.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.UpdateInfo;

import java.util.List;

/**
 * @ClassName : IUpdateService
 * @Description : 更新信息服务接口
 * @Author : WDD
 * @Date: 2020-07-20 16:19
 */
public interface IUpdateService {

    public List<UpdateInfo>getAllEnUpdateInfoList();
    public List<UpdateInfo>getAllChUpdateInfoList();
}
