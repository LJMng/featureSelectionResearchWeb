package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.mybatisMapper.demo.visitor.DatasetMapper;
import featureSelection.research.web.service.demo.visitor.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : DatasetServiceimpl
 * @Description :数据集服务类
 * @Author : WDD
 * @Date: 2020-04-16 18:21
 */
@Service
public class DatasetServiceImpl implements DatasetService {
    @Autowired
    private DatasetMapper datasetMapper;

    //根据数据集id获取数据集信息
    @Override
    public Dataset getDatesetInfo(int datasetid){
        return datasetMapper.getDatasetInfo(datasetid);
    }
}
