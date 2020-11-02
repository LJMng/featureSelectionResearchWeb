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
public class IAlgorithmServiceImpl implements IAlgorithmService {

    @Autowired
    private AlgorithmMapper algorithmMapper;
    @Autowired
    private DatasetMapper datasetMapper;

    /**
     * 获取所有设置过方案以及可用数据集的算法的基本信息
     *
     * @return 所有算法的基本信息
     */
    @Override
    public List<Algorithm> getAllAlgorithmInfo() {

        List<Algorithm> algorithmList = algorithmMapper.getAllAlgorithmInfo();
        for (Algorithm algorithm : algorithmList) {
            if (algorithm.getParameterSchemes() != null) {
                System.out.println(algorithm.getParameters()==null);
                if (algorithm.getAvailableDatasetsString() != null) {
                    JSONArray algorithAvailableDatasetIndexStringJsonArray = JSONArray.parseArray(algorithm.getAvailableDatasetsString());
                    List<Dataset> datasets = new ArrayList<>();
                    for (Object datasetIndex : algorithAvailableDatasetIndexStringJsonArray) {
                        datasets.add(datasetMapper.getDatasetInfo(Integer.parseInt(datasetIndex.toString())));
                    }
                    algorithm.setDatasets(datasets);
                } else {
                    //不存在数据集
                    algorithmList.remove(algorithm);
                    //todo:遍历集合时删除元素会报错（java.util.ConcurrentModificationException: null）,先用break的方法解决
                    break;
                }

            } else {
                //不存在方案
                algorithmList.remove(algorithm);
                break;
            }

        }
        return algorithmList;
    }

}
