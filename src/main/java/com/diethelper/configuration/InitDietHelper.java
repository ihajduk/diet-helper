package com.diethelper.configuration;

import com.github.dandelion.core.web.DandelionServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by iwoha on 7/26/2016.
 */
public class InitDietHelper extends AbstractDispatcherServletInitializer {
    private static final String DB_PROFILE = "jpa";
    private static final String DANDELION_SERVLET = "dandelionServlet";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerDandelionServlet(servletContext);
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext webAppContext = new XmlWebApplicationContext();
        webAppContext.setConfigLocation("classpath:META-INF/mvc-config.xml");
        return webAppContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        XmlWebApplicationContext rootAppContext = new XmlWebApplicationContext();
        rootAppContext.setConfigLocations("classpath:META-INF/business-config.xml");
        rootAppContext.getEnvironment().setActiveProfiles(DB_PROFILE);
        return rootAppContext;
    }

    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
        FilterRegistration.Dynamic registration = super.registerServletFilter(servletContext, filter);
        registration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, DANDELION_SERVLET);
        return registration;
    }

    private void registerDandelionServlet(ServletContext servletContext) {
        DandelionServlet dandelionServlet = new DandelionServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet(DANDELION_SERVLET, dandelionServlet);
        registration.setLoadOnStartup(2);
        registration.addMapping("/dandelion-assets/*");
    }
}
