package ttps.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebApp implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);

		//ContextLoaderListener - Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));

		//DispatcherServlet - Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("DispatcherServlet", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}
