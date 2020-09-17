package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 算法业务层接口
 * @Author: 马凯健
 * @data: 2020-07-18
 */
public interface AlgorithmBusiness {
    /**
     * 添加参数信息
     * @param algorithmMap <Integer,String>
     *                     Integer是算法的Id
     *                     String 是算法参数的详细信息，为Json字符串
     */
    public void createParamSettingInfo(Map<Integer, String> algorithmMap);

    /**
     * 添加算法步骤
     * @param procedureSettings 封装算法步骤信息的实体类
     */
    public void addProcedureSettings(ProcedureSettings procedureSettings);

    /**
     * 查找所有算法步骤信息,前端页面加载时调用该方法，用于显示算法步骤信息。
     * @return List<ProcedureSettings> 封装算法步骤信息的线性表
     */
    public List<ProcedureSettings> findAllProcedureSettings();

    /**
     *修改算法步骤信息
     * @param procedureSettings 封装算法步骤信息的实体类
     */
    public void updateProcedureSettings(ProcedureSettings procedureSettings);

    /**
     * 查找所以算法信息
     * @return List<Algorithm> 封装算法信息实体类的线性表
     */
    public List<Algorithm> getAlgorithms();

    /**
     * 给对应的算法添加新的参数
     * @param parameterInfo 封装算法信息的实体类
     */
    public void createParameters(ParameterInfo parameterInfo);

    /**
     * 查找所有参数信息
     * @return List<Parameter> 封装参数信息实体类的线性表
     */
    public List<Parameter> getParameters();

    /**
     * 根据算法id,修改相应算法的参数
     * @param parameter 封装算法参数的实体类
     */
    public void updateParameter(Parameter parameter);

    /**
     * 根据参数Id,删除算法参数
     * @param parameterId int 算法参数Id
     */
    public void deleteParameter(int parameterId);

    /**
     * 根据步骤Id,删除对应的算法步骤
     * @param id int 算法步骤Id
     */
    public void deleteProcedureSetting(int id);

    /**
     * 设置每个算法可以运行的公共数据集
     * @param availableDataset4Algorithm
     */
    public void setAvailableDataset4Algorithm(AvailableDataset4Algorithm availableDataset4Algorithm);

    /**
     * 根据算法详细信息的excel文件，添加算法的信息，算法参数,算法步骤
     * @param excel
     */
    public void addAlgorithmInfoByExcelFile(MultipartFile excel) throws Exception;
}
