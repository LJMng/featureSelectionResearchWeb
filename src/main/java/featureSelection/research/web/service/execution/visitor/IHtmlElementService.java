package featureselection.research.web.service.execution.visitor;

import featureselection.research.web.entity.Algorithm;
import featureselection.research.web.entity.Dataset;
import featureselection.research.web.entity.HtmlElementControl;
import featureselection.research.web.entity.Parameter;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/21 16:36
 */
public interface IHtmlElementService {

    /**
     * 获取Execution系统中页面元素的内容
     * @return List<HtmlElementControl>
     */
    List<HtmlElementControl> getElementsContext();

    /**
     * 获取算法信息
     * @return Map<Long, Algorithm>
     */
    Map<Long, Algorithm> getAlgorithmsList();

    /**
     * 获取所有算法的参数的信息
     * @return Map<Long, List<Parameter>> key为algorithmId
     */
    Map<Long, List<Parameter>> getParametersList();

    /**
     * 获取公共数据集的信息
     * @return Map<Long, Dataset> key为公共数据集Id
     */
    Map<Long, Dataset> getDatasetList();
}
