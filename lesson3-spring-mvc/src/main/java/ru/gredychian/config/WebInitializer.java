package ru.gredychian.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.gredychian.AppConfig;

import java.util.logging.Filter;

//с помощью данного класса можно конфигурировать сервлеты

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class};
        //из класса ApplicationConfig берётся конфиурация сервлета
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
        //здесь говорится за Mapping
    }

    @Override
    protected javax.servlet.Filter[] getServletFilters() {
        // Создание фильтра кодировки, который позволит работать с русскими
        // символами
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8"); //постановка кадировки
        characterEncodingFilter.setForceEncoding(true);
        // Создание фильтра, который добавляет поддержку HTTP-методов (например
        // таких, как PUT), необходимых для REST API
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        return (javax.servlet.Filter[]) new Filter[]{(Filter) characterEncodingFilter, (Filter) httpMethodFilter};
    }
}
