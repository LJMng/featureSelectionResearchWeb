package featureSelection.research.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName : appConfigs
 * @Description : app配置类
 * @Author : WDD
 * @Date: 2020-07-18 19:55
 */
@Component
public class appConfigs {

    private static int  MaxExceptionNumberPerMinute4Exit=100;
    private static String  ReciverExceptionNoticeEmail;

    @Value("${appconfigs.MaxExceptionNumberPerMinute4Exit}")
    public  void setMaxExceptionNumberPerMinute4Exit(int maxExceptionNumberPerMinute4Exit) {
        MaxExceptionNumberPerMinute4Exit = maxExceptionNumberPerMinute4Exit;
    }

    @Value("${appconfigs.ReciverExceptionNoticeEmail}")
    public  void setReciverExceptionNoticeEmail(String reciverExceptionNoticeEmail) {
        ReciverExceptionNoticeEmail = reciverExceptionNoticeEmail;
    }

    public static String getReciverExceptionNoticeEmail() {
        return ReciverExceptionNoticeEmail;
    }

    public static int getMaxExceptionNumberPerMinute4Exit() {
        return MaxExceptionNumberPerMinute4Exit;
    }
}
