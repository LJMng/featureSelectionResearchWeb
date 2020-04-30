package featureSelection.research.web.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfiguration {

	@Bean(destroyMethod ="close", initMethod="init")
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource druidDataSource () {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource ;
	}

	@Bean(name = "webSqlSessionFactory")
	@Primary
    public SqlSessionFactory webSqlSessionFactory(@Qualifier("druidDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
}