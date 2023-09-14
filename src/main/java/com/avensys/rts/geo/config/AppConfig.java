package com.avensys.rts.geo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.avensys.rts.geo.interceptor.AuditInterceptor;
import com.avensys.rts.geo.interceptor.AuthInterceptor;

import javax.sql.DataSource;


/**
 * 
 * @author Pranay.Patadiya
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    /**
     * This method is used to register the interceptors.
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuditInterceptor());
        registry.addInterceptor(new AuthInterceptor());
    }

    /**
     * This method is used to configure the message source for internationalization.
     * These messages are used to display error messages to the user.
     * These messages are used to send back messages in response
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource ();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }


    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);

        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("sql/countries_202308291814.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("sql/cities_202308291814.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("sql/states_202308291815.sql"));
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);

        return dataSourceInitializer;
    }
}