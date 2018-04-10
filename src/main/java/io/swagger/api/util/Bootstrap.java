package io.swagger.api.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class Bootstrap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        BeanConfig beanConfig = new BeanConfig();
//      beanConfig.setHost("localhost:8080");
//      beanConfig.setBasePath("/curcon/rest/");
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest/");
        beanConfig.setContact("berend.wilkens@hu.nl");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setTitle("CurCon API");
        beanConfig.setDescription("Swagger description of the CurCon API.");
        beanConfig.setVersion("1.0.0");
        beanConfig.setResourcePackage("nl.hu.curcon.rest");
        beanConfig.setLicense("Copyright University of applied sciences Utrecht, Netherlands, 2018.");
        beanConfig.setScan(true);
    }
}