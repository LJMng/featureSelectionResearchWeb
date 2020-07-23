package featureSelection.research.web.config.interceptor;

import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.Administrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 马凯健
 * @Date 2020-07-23
 */
public class AdminLoginInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Administrator administrator = (Administrator) request.getSession().getAttribute("administrator");
            if (administrator != null) {
                return true;
            }
            System.out.println("请求被拦截");

            response.sendRedirect("executionAdminLogin.html");


        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
