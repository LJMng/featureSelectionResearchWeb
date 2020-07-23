package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.entity.demo.visitor.UpdateInfo;
import featureSelection.research.web.mybatisMapper.demo.visitor.UpdateMapper;
import featureSelection.research.web.service.demo.visitor.IUpdateService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName : IUpdateServiceImpl
 * @Description : 更新信息服务实现类
 * @Author : WDD
 * @Date: 2020-07-20 16:21
 */
@Service
public class IUpdateServiceImpl implements IUpdateService {

    @Autowired private UpdateMapper updateMapper;
    @Override
    public List<UpdateInfo> getAllEnUpdateInfoList() {
        List<UpdateInfo>updateInfoList=updateMapper.getAllUpdateInfoList();
        for (UpdateInfo updateInfo:updateInfoList) {
            updateInfo.setUpdateContent(updateInfo.getUpdateEnContent());
        }
        return updateInfoList;
    }

    @Override
    public List<UpdateInfo> getAllChUpdateInfoList() {
        return updateMapper.getAllUpdateInfoList();
    }
}
