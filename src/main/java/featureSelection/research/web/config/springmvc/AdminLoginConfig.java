package featureSelection.research.web.config.springmvc;

import featureSelection.research.web.config.interceptor.AdminLoginInterceptor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 马凯键
 * @Date  2020-08-17
 */
@Configuration
public class AdminLoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminLoginInterceptor())
                .addPathPatterns("/pages/execution/admin/**.html")
                .excludePathPatterns("/**/admin/executionAdminLogin.html");
    }
}
