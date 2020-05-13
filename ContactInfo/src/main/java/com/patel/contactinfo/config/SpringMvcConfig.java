
package com.patel.contactinfo.config;

import com.patel.contactinfo.Dao.contactDao;
import com.patel.contactinfo.Dao.contactDaoImp;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author DELL
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.patel.contactinfo")
 
class SpringMvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public DataSource getDatasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/contactdb");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver re = new  InternalResourceViewResolver();
        re.setPrefix("/WEB-INF/views/");
        re.setSuffix(".jsp");
        return re;
    }
    
    @Bean
    public contactDao getcontactDao(){
        return new contactDaoImp(getDatasource());
    }
}
