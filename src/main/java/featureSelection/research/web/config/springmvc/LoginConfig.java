package featureSelection.research.web.config.springmvc;

import featureSelection.research.web.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Stephen
 * @date 2020/7/18 17:04
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/execution/**").excludePathPatterns(
                        "/execution",
                        "localhost:8000/pages/execution/admin/executionAdminLogin.html",
                        "/execution/getProcedureSettingsList",
                        "/execution/getParameterList",      //开放接口提供内部调用
                        "/index",
                        "/",
                        "/index.html",
                        "/accountLogin",          //登录
                        "/**/*.html",            //html静态资源
                        "/**/*.js",              //js静态资源
                        "/**/*.css",             //css静态资源
                        "/**/*.jpg",            //图片静态资源
                        "/**/*.woff",
                        "/**/*.ttf");
    }
}
