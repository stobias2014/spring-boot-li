package com.tobias.saul.springmvcli.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// bootstrap dispatcher servlet
		
		AnnotationConfigWebApplicationContext webcx = new AnnotationConfigWebApplicationContext();
		
		ServletRegistration.Dynamic servletRegistration = 
				servletContext.addServlet("mvc", new DispatcherServlet(webcx));
		
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/");
		
	}

}
