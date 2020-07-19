package featureSelection.research.web.common.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName : DemoExceptionHistroyService
 * @Description : demo系统异常历史服务类
 * @Author : WDD
 * @Date: 2020-07-18 19:45
 */
public class ExceptionHistroyService {

    private static int demoExceptionCount; //demo系统出现的异常数
    private static int executionExceptionCount; //execution系统出现的异常数

    public static int getDemoExceptionCount() {
        return demoExceptionCount;
    }

    public static int getExecutionExceptionCount() {
        return executionExceptionCount;
    }
    public static void addDemoExceptionCount(){
        demoExceptionCount++;
    }
    public static void addExecutionExceptionCount(){
        executionExceptionCount++;
    }
    public static void resetDemoExceptionCount(){
        demoExceptionCount=0;
    }
    public static void resetExecutionExceptionCount(){
        executionExceptionCount=0;
    }
}
