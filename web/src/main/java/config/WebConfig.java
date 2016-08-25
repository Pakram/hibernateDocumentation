package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.Resources;

/**
 * Created by Pokramovich on 23.08.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "controller")
@PropertySource(value = "classpath:dbProperty.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    Environment environment;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");

    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Bean(autowire = Autowire.BY_NAME,destroyMethod = "close")
    public DataSource createDataSource(){
        DataSource dataSource=new DataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setMaxIdle(40);
        dataSource.setMinIdle(20);
        dataSource.setSuspectTimeout(60);
        dataSource.setTimeBetweenEvictionRunsMillis(30000);
        dataSource.setInitialSize(15);
        dataSource.setMaxActive(300);
        dataSource.setMinEvictableIdleTimeMillis(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setValidationInterval(30000);
        dataSource.setTestOnBorrow(true);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(60);
        dataSource.setAbandonWhenPercentageFull(50);
        dataSource.setMaxWait(30000);
        dataSource.setLogAbandoned(true);
        dataSource.setLogValidationErrors(true);
        dataSource.setJdbcInterceptors("ConnectionState;ResetAbandonedTimer;StatementFinalizer;SlowQueryReportJmx(threshold=1000)");
return dataSource;
    }

}
