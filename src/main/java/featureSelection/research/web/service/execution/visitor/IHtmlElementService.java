package featureSelection.research.web.service.execution.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import featureSelection.research.web.entity.execution.visitor.*;

import java.util.List;
import java.util.Map;

/**
 * Execution系统中与页面基础内容展示的Service
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
     * @return Map<Integer, Algorithm>
     */
    Map<Integer, Algorithm> getAlgorithmsList();

    /**
     * 获取所有算法的参数的信息
     * @return Map<Integer, List<Parameter>> key为algorithmId，value为该算法所有参数设置的信息
     */
    Map<Integer, List<Parameter>> getParametersList();

    /**
     * 获取公共数据集的信息
     * @return Map<Integer, Dataset> key为公共数据集Id
     */
    Map<Integer, Dataset> getDatasetList();

    /**
     * 获取算法任务步骤设置的信息
     * @return Map<Integer,List<ProcedureSettings>> key为算法id，value为改算法所有步骤设置的信息
     */
    Map<Integer,List<ProcedureSettings>> getProcedureSettingList();

    List<Integer> getAuthorizationDownloadAlgDocs(Integer accountId);

    List<Integer> getAuthorizationUploadAlgDocs(Integer accountId);

    public Map<Integer, List<Map<String, String>>> getAlgDocsMap() throws JsonProcessingException;
}
