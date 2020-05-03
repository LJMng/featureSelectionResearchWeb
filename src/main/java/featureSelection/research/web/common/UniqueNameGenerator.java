package featureSelection.research.web.common;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @ClassName : UniqueNameGenerator
 * @Description : 自己写一个类实现 org.springframework.beans.factory.support.BeanNameGeneraot接口，实现全限定类名
 * @Author : WDD
 * @Date: 2020-05-03 11:33
 */
public class UniqueNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        //全限定类名
        String beanName = definition.getBeanClassName();
        return beanName;
    }
}
