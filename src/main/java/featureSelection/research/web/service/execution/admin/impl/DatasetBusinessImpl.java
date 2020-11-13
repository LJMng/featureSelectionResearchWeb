package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.common.util.EmailUtil;
import featureSelection.research.web.common.util.FileUtil;
import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.Dataset;
import featureSelection.research.web.entity.execution.admin.DatasetForm;
import featureSelection.research.web.entity.execution.admin.ToEmail;
import featureSelection.research.web.mybatisMapper.execution.admin.AccountMapper;
import featureSelection.research.web.mybatisMapper.execution.admin.DatasetMapping;
import featureSelection.research.web.service.execution.admin.DatasetBusiness;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class DatasetBusinessImpl implements DatasetBusiness {
    private  static final String UPLOAD_BASE="dataset/datasetHome/";

    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private DatasetMapping datasetMapping;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private AccountMapper accountMapper;
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
    public void passDatasetForm(int inputId,String administratorName) throws MessagingException {
        //获取申请表单对象
        DatasetForm datasetForm=datasetMapping.getDatasetFormById(inputId);
        //获取文件地址，将数据集文件复制到公共数据集文件夹
        String inputFile=datasetForm.getInputFile();
        File source=new File(datasetForm.getInputFile());
        String fileName= FilenameUtils.getName(datasetForm.getInputFile());
        File target=new File (UPLOAD_BASE+fileName);
        Account account = accountMapper.getAccountById(datasetForm.getAccountId());
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
        datasetForm.setInputReviewer(administratorName);
        datasetMapping.updateDatasetForm(datasetForm);
        //将数据集信息添加到数据集表
        Dataset dataset=new Dataset();
        dataset.setDatasetId(datasetForm.getInputId());
        dataset.setDatasetFile(target.getPath());
        dataset.setCommon(true);
        dataset.setDatasetName(datasetForm.getInputName());
        dataset.setDatasetDescription(datasetForm.getInputDescription());
        dataset.setDatasetSource(datasetForm.getInputHref());
        double size = (double)target.length()/1024;
        DecimalFormat df = new DecimalFormat("#.####");
        dataset.setDatasetSize(df.format(size)+"KB");
        dataset.setDatasetDimension(datasetForm.getInputDimension());
        dataset.setDatasetTags(datasetForm.getInputTag());
        dataset.setDatasetRecords(String.valueOf(datasetForm.getInputRecord()));
        dataset.setDatasetType(datasetForm.getInputType());
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
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        String htmlEmailContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>邮件提醒</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"margin: 0; padding: 0;\">\n" +
                "\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <div style=\"margin: 20px;text-align: center;margin-top: 50px\">\n" +
                "                <img src=\"gdutLogo.jpg\" border=\"0\" style=\"display:block;width: 30%;height: 30%\">\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <div style=\"border: #36649d 1px dashed;margin: 30px;padding: 20px\">\n" +
                "                <label style=\"font-size: 22px;color: #36649d;font-weight: bold\">恭喜您，上传数据集成功！</label>\n" +
                "                <p style=\"font-size: 16px\">这里是&nbsp;<label style=\"font-weight: bold\"> featureSelection算法平台</label>&nbsp;\n" +
                "                </p>\n" +
                "                <p style=\"font-size: 16px\">恭喜您成功向featureSeletion平台上传数据集，数据集名称："+datasetForm.getInputName()+"</p>\n" +
                "                <p>欢迎再次使用本平台功能！</p>\n" +
                "                <p>平台登陆地址：<a href=\"/execution\">http://www.featureSelection.com</a></p>\n" +
                "                <p>联系方式：XXXXXXXXXX</p>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <div align=\"right\" style=\"margin: 40px;border-top: solid 1px gray\" id=\"bottomTime\">\n" +
                "                <p style=\"margin-right: 20px\">featureSelection 算法平台</p>\n" +
                "                <label style=\"margin-right: 20px\">"+dateString+"</label>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        ToEmail toEmail=new ToEmail(account.getAccountEmail(),"上传数据集成功",htmlEmailContent);
        emailUtil.htmlEmail(toEmail);
    }

    @Override
    public void unPassDatasetForm(int inputId, String advice,String administratorName) throws MessagingException {
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
        datasetForm.setInputReviewer(administratorName);
        datasetMapping.updateDatasetForm(datasetForm);
        Account account = accountMapper.getAccountById(datasetForm.getAccountId());
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
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        String htmlEmailContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>邮件提醒</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"margin: 0; padding: 0;\">\n" +
                "\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <div style=\"margin: 20px;text-align: center;margin-top: 50px\">\n" +
                "                <img src=\"gdutLogo.jpg\" border=\"0\" style=\"display:block;width: 30%;height: 30%\">\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <div style=\"border: #36649d 1px dashed;margin: 30px;padding: 20px\">\n" +
                "                <label style=\"font-size: 22px;color: #36649d;font-weight: bold\">很遗憾，上传数据集失败！</label>\n" +
                "                <p style=\"font-size: 16px\">这里是&nbsp;<label style=\"font-weight: bold\"> featureSelection算法平台</label>&nbsp;\n" +
                "                </p>\n" +
                "                <p style=\"font-size: 16px\">很遗憾您上传的数据集没能通过审核，数据集名称："+datasetForm.getInputName()+"</p>\n" +
                "                <p>未通过审核原因："+advice+"</p>\n" +
                "                <p>欢迎再次使用本平台功能！</p>\n" +
                "                <p>平台登陆地址：<a href=\"/execution\">http://www.featureSelection.com</a></p>\n" +
                "                <p>联系方式：XXXXXXXXXX</p>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <div align=\"right\" style=\"margin: 40px;border-top: solid 1px gray\" id=\"bottomTime\">\n" +
                "                <p style=\"margin-right: 20px\">featureSelection 算法平台</p>\n" +
                "                <label style=\"margin-right: 20px\">"+dateString+"</label>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        ToEmail toEmail=new ToEmail(account.getAccountEmail(),"上传数据集成功",htmlEmailContent);
        emailUtil.htmlEmail(toEmail);
    }
}
