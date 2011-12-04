package org.graduates.webapp.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.dayatang.domain.InstanceFactory;
import com.dayatang.spring.factory.SpringProvider;

public class InitializationListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// do nothing!
	}

	public void contextInitialized(ServletContextEvent event) {
		initializeInstanceProvider(ContextLoader.getCurrentWebApplicationContext());
	}

	private void initializeInstanceProvider(ApplicationContext applicationContext) {
		SpringProvider springProvider = new SpringProvider(applicationContext);
		InstanceFactory.setInstanceProvider(springProvider);
	}

}
