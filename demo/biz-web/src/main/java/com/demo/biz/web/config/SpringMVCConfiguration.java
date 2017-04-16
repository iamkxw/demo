package com.demo.biz.web.config;

import com.demo.common.log.AppLogger;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import java.util.List;

/**
 * spring mvc基本配置文件
 *
 * @author kxw
 * @version 2017/2/10 14:31
 */
@Configuration
public class SpringMVCConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/").setCachePeriod(31556926);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        AppLogger.sysLogger.info("开始打印转换器");
        for (HttpMessageConverter converter : converters) {
            AppLogger.sysLogger.info(converter + converter.getSupportedMediaTypes().toString());
        }
        AppLogger.sysLogger.info("转换器打印完毕");
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("5MB");
        factory.setMaxRequestSize("5MB");
        return factory.createMultipartConfig();
    }
}