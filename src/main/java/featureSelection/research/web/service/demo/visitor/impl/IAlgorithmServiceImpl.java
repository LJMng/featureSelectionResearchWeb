package featureSelection.research.web.service.demo.visitor.impl;

import com.alibaba.fastjson.JSONArray;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.DatasetMapper;
import featureSelection.research.web.service.demo.visitor.IAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : AlgorithmserviceImpl
 * @Description : 算法服务
 * @Author : WDD
 * @Date: 2020-04-12 20:46
 */
@Service
public  class IAlgorithmServiceImpl implements IAlgorithmService {

    @Autowired private AlgorithmMapper algorithmMapper;
    @Autowired private DatasetMapper datasetMapper;

    /**
     *  获取所有算法的基本信息
     * @return 所有算法的基本信息
     */
    @Override
    public List<Algorithm>getAllAlgorithmInfo(){

        List<Algorithm> algorithmList=algorithmMapper.getAllAlgorithmInfo();
        for (Algorithm algorithm : algorithmList){
            JSONArray algorithAvailableDatasetIndexStringJsonArray= JSONArray.parseArray(algorithm.getAvailableDatasetsString());
            List<Dataset>datasets =new ArrayList<>();
            for (Object datasetIndex: algorithAvailableDatasetIndexStringJsonArray){
                datasets.add(datasetMapper.getDatasetInfo(Integer.parseInt(datasetIndex.toString())));
            }
            algorithm.setDatasets(datasets);
        }
        return algorithmList;
    }

}
