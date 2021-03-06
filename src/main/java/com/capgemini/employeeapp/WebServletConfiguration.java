package com.capgemini.employeeapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//creating object of container (webApplicationContext)
AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();

//specify Spring MVC configuration class.
context.register(SpringMvcConfig.class);
context.setServletContext(servletContext);

ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher", new DispatcherServlet(context));
dispatcher.setLoadOnStartup(1);
dispatcher.addMapping("/");
	}

}
