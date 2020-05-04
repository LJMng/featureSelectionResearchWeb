package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Dataset;
import featureSelection.research.web.entity.execution.admin.DatasetForm;
import featureSelection.research.web.entity.execution.admin.ToEmail;
import featureSelection.research.web.mybatisMapper.execution.admin.DatasetMapping;
import featureSelection.research.web.service.execution.admin.DatasetBusiness;
import featureSelection.research.web.common.EmailUtil;
import featureSelection.research.web.common.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class DatasetBusinessImpl implements DatasetBusiness {
    private  static final String UPLOAD_BASE="src/main/resources/static/dataset/datasetHome/";
    private static final String TEMP_BASE="/dataset/temp/";
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private DatasetMapping datasetMapping;
    @Autowired
    private FileUtil fileUtil;
    @Override
    public void createDataset(Dataset dataset, MultipartFile file) throws Exception {
        //将文件存在datasetHome
        File source=fileUtil.multipartFileToFile(file);
        File target=new File (UPLOAD_BASE+file.getOriginalFilename());
        FileUtils.copyFile(source,target);
        datasetMapping.createDataset(dataset);

    }

    @Override
    public List<Dataset> getDatasetList() {
        List<Dataset> datasetList=datasetMapping.getDatasetList();
        return datasetList;
    }

    @Override
    public void deleteDatasetById(int datasetId) {
        datasetMapping.deleteDatasetById(datasetId);
    }

    @Override
    public boolean updateDataset(Dataset dataset) {
        datasetMapping.updateDataset(dataset);
        return true;
    }

    @Override
    public List<DatasetForm> getDatasetForms() {
        List<DatasetForm> datasetForms=datasetMapping.getDatasetForms();
        return datasetForms;
    }

    @Override
    public void passDatasetForm(int inputId) throws MessagingException {
        //获取申请表单对象
        DatasetForm datasetForm=datasetMapping.getDatasetFormById(inputId);
        //获取文件地址，将数据集文件复制到公共数据集文件夹
        String inputFile=datasetForm.getInputFile();
        File source=new File("src/main/resources/static/dataset/temp/newfile.xlsx");
        String fileName= FilenameUtils.getName(datasetForm.getInputFile());
        File target=new File (UPLOAD_BASE+fileName);
        try {
            FileUtils.copyFile(source,target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //修改申请表单信息
        /*
        1.修改表单状态
        2.设置审批时间
        3.设置审批人
         */
        datasetForm.setInputStatus("通过审核");
        datasetForm.setInputEndTime(new Date());
        datasetForm.setInputReviewer("ccjmkj");
        datasetMapping.updateDatasetForm(datasetForm);
        //将数据集信息添加到数据集表
        Dataset dataset=new Dataset();
        dataset.setDatasetId(datasetForm.getInputId());
        dataset.setDatasetFile(datasetForm.getInputFile());
        System.out.println(datasetForm.getInputFile());
        dataset.setDatasetCount(datasetForm.getInputRecord());
        dataset.setCommon(true);
        dataset.setDatasetName(datasetForm.getInputName());
        dataset.setDatasetDescription(datasetForm.getInputDescription());
        dataset.setDatasetSource(datasetForm.getInputHref());
        //维度的类型?
//        dataset.setDatasetDimension(datasetForm.getInputDimension());
        datasetMapping.createDataset(dataset);
        //发送邮件给用户
        /*
        邮件内容：
        1.提醒用户上传成功的话
        2.数据集名称
        3.数据集文件
        4.上传时间
        5.通过时间
        6.欢迎再次使用平台
         */
        String content="<html>\n" +
                "\t<body>\n" +
                "\t\t<h2 align=\"center\">这里是xxx平台 恭喜你上传数据集成功！！</h2>\n" +
                "\t\t<div class=\"container\">\n" +
                "\t\t\t<p>上传数据集的名称"+datasetForm.getInputName()+"</p>\n" +
                "\t\t\t<p>上传数据集时间："+datasetForm.getInputReviewTime()+"</p>\n" +
                "\t\t\t<p>数据集通过审核时间："+datasetForm.getInputEndTime()+"</p>\n" +
                "\t\t\t<p align=\"center\">欢迎再次使用本平台</p>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>";

        ToEmail toEmail=new ToEmail("1009710828@qq.com","上传数据集成功",content);
        emailUtil.htmlEmail(toEmail);
    }

    @Override
    public void unPassDatasetForm(int inputId, String advice) {
        //获取申请表单对象
        DatasetForm datasetForm=datasetMapping.getDatasetFormById(inputId);
        //获取文件地址，删除文件
        String inputFile=datasetForm.getInputFile();
        File source=new File("src/main/resources/static/dataset/temp/newfile.xlsx");
        FileUtils.deleteQuietly(source);
        //修改申请表单信息
        /*
        1.修改表单状态
        2.设置审批时间
        3.设置审批人
         */
        datasetForm.setInputStatus("不通过");
        datasetForm.setInputEndTime(new Date());
        datasetForm.setInputReviewer("ccjmkj");
        datasetMapping.updateDatasetForm(datasetForm);
        //发送邮件给用户
        /*
        邮件内容：
        1.提醒用户上传成功的话
        2.数据集名称
        3.数据集文件
        4.上传时间
        5.通过时间
        6.欢迎再次使用平台
         */
        String content="<html>\n" +
                "\t<body>\n" +
                "\t\t<h2 align=\"center\">这里是xxx平台 恭喜你上传数据集成功！！</h2>\n" +
                "\t\t<div class=\"container\">\n" +
                "\t\t\t<p>上传数据集的名称"+datasetForm.getInputName()+"</p>\n" +
                "\t\t\t<p>不通过原因："+advice+"</p>\n" +
                "\t\t\t<p>上传数据集时间："+datasetForm.getInputReviewTime()+"</p>\n" +
                "\t\t\t<p>数据集通过审核时间："+datasetForm.getInputEndTime()+"</p>\n" +
                "\t\t\t<p align=\"center\">欢迎再次使用本平台</p>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>";


    }
}
