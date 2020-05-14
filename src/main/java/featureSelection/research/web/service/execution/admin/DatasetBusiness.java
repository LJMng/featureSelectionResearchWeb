package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Dataset;
import featureSelection.research.web.entity.execution.admin.DatasetForm;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.util.List;

public interface DatasetBusiness {
    public void createDataset(Dataset dataset, MultipartFile datasetFile) throws Exception;

    public List<Dataset> getDatasetList();

    public void deleteDatasetById(int datasetId);

    public boolean updateDataset(Dataset dataset);

    public List<DatasetForm> getDatasetForms();

    public void passDatasetForm(int inputId,String administrator) throws MessagingException;

    public void unPassDatasetForm(int inputId, String advice,String administratorName);
}
