package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import featureSelection.research.web.service.demo.visitor.IAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : AlgorithmserviceImpl
 * @Description : 算法服务
 * @Author : WDD
 * @Date: 2020-04-12 20:46
 */
@Service
public  class IAlgorithmServiceImpl implements IAlgorithmService {

    @Autowired
    private AlgorithmMapper algorithmMapper;

    /**
     *  获取所有算法的基本信息
     * @return 所有算法的基本信息
     */
    @Override
    public List<Algorithm>getAllAlgorithmInfo(){

        return algorithmMapper.getAllAlgorithmInfo();
    }

}
