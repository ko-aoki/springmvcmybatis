package com.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * このクラスを作成するだけで、DispatcherServletがサーブレットコンテナに登録されます。
 * Servlet 3.0から導入されたServlet Initializerの機能を利用しています。
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // getRootConfigClasses()をオーバーライドしてnullをreturnする
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                MvcConfig.class, MyBatisConfig.class, ServiceConfig.class,};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
}
