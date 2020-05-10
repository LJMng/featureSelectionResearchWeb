package featureSelection.research.web.common.util;

import featureSelection.research.web.entity.execution.admin.ToEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    public boolean commonEmail(ToEmail toEmail) {
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(from);
        //谁要接收
        message.setTo(toEmail.getToAccount());
        //邮件标题
        message.setSubject(toEmail.getSubject());
        //邮件内容
        message.setText(toEmail.getContent());
        try {
            mailSender.send(message);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean htmlEmail(ToEmail toEmail) throws MessagingException {
        //创建一个MINE消息
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper minehelper = new MimeMessageHelper(message, true);
        //谁发
        minehelper.setFrom(from);
        //谁要接收
        minehelper.setTo(toEmail.getToAccount());
        //邮件主题
        minehelper.setSubject(toEmail.getSubject());
        //邮件内容   true 表示带有附件或html
        minehelper.setText(toEmail.getContent(), true);
        try {
            mailSender.send(message);            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean enclosureEmail(ToEmail toEmail, MultipartFile multipartFile) {
//        //创建一个MINE消息
//        MimeMessage message = mailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            //谁发
//            helper.setFrom(from);
//            //谁接收
//            helper.setTo(toEmail.getToAccount());
//            //邮件主题
//            helper.setSubject(toEmail.getSubject());
//            //邮件内容   true 表示带有附件或html
//            helper.setText(toEmail.getContent(), true);
//            File multipartFileToFile = MultipartFileToFile(multipartFile);
//            FileSystemResource file = new FileSystemResource(multipartFileToFile);
//            String filename = file.getFilename();
//            //添加附件
//            helper.addAttachment(filename, file);
//            mailSender.send(message);
//            return true;
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }





}
