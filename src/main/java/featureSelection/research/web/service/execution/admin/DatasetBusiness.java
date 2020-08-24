package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Dataset;
import featureSelection.research.web.entity.execution.admin.DatasetForm;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.util.List;

/**
 * 数据集管理业务层接口类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public interface DatasetBusiness {
    /**
     * 创建新的数据集
     * @param dataset 封装数据集的实体类
     * @param datasetFile 数据集文件
     * @throws Exception
     */
    public void createDataset(Dataset dataset, MultipartFile datasetFile) throws Exception;

    /**
     * 查询获取所有数据集信息
     * @return List<Dataset> 封装数据集实体类的线性表
     */
    public List<Dataset> getDatasetList();

    /**
     * 通过数据集Id,删除数据集信息
     * @param datasetId int 数据集Id
     */
    public void deleteDatasetById(int datasetId);

    /**
     * 修改数据集信息
     * @param dataset 封装数据集信息的实体类
     * @return boolean "true" or "false"
     */
    public boolean updateDataset(Dataset dataset);

    /**
     * 获取所有待审核数据集信息
     * @return List<DatasetForm> 封装待审核数据集信息实体类的线性表
     */
    public List<DatasetForm> getDatasetForms();

    /**
     * 通过审核的数据集，通过审核后，将数据集信息存入数据库，同时通过邮箱通知用户。
     * @param inputId int 审核Id
     * @param administrator String 审核管理员的姓名
     * @throws MessagingException
     */
    public void passDatasetForm(int inputId,String administrator) throws MessagingException;

    /**
     * 不通过审核数据集信息，同时通过邮箱通知用户。
     * @param inputId int 审核Id
     * @param advice String 不通过审核的理由
     * @param administratorName String 审核管理员的姓名
     */
    public void unPassDatasetForm(int inputId, String advice,String administratorName);

}
