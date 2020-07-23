package featureSelection.research.web.common.service;

import featureSelection.research.web.common.util.EmailUtil;
import featureSelection.research.web.config.appConfigs;
import featureSelection.research.web.entity.execution.admin.ToEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @ClassName : ExceptionTimeingMonitorService
 * @Description : 异常定时监测服务
 * @Author : WDD
 * @Date: 2020-07-18 19:54
 */
@Component
public class ExceptionTimeingMonitorService {
    private final static Logger log = LoggerFactory.getLogger(ExceptionTimeingMonitorService.class);
    @Autowired private EmailUtil emailUtil;
    @Async
    @Scheduled(fixedRate = 60*1000)
    public void checkExit4Exception(){
        if (appConfigs.getMaxExceptionNumberPerMinute4Exit()>0){
            int currentExceutionExceptionNumber=ExceptionHistroyService.getExecutionExceptionCount();
            int currentDemoExceptionNumber=ExceptionHistroyService.getDemoExceptionCount();
            if (currentDemoExceptionNumber>=appConfigs.getMaxExceptionNumberPerMinute4Exit()){
                try {
                String notice=String.format("exit System for the error over 100 per min :"+new Date().toString());
                log.warn(notice);
                    ToEmail toEmail=new ToEmail(appConfigs.getReciverExceptionNoticeEmail(),"notice",notice);
                    emailUtil.commonEmail(toEmail);

                }finally {
                    exitProgram();
                }
            }
            if (currentExceutionExceptionNumber>=appConfigs.getMaxExceptionNumberPerMinute4Exit()){
                try {
                    String notice=String.format("exit System for the error over 100 per min :"+new Date().toString());
                    ToEmail toEmail=new ToEmail(appConfigs.getReciverExceptionNoticeEmail(),"notice",notice);
                    emailUtil.commonEmail(toEmail);
                    log.warn(notice);
                }finally {
                    exitProgram();
                }
            }
        }else{
            ExceptionHistroyService.resetDemoExceptionCount();
            ExceptionHistroyService.resetExecutionExceptionCount();
        }
    }

    @Autowired
    private ConfigurableApplicationContext context;
    private void exitProgram(){
        context.close();
    }
}
