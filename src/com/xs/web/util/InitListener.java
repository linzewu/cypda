package com.xs.web.util;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xs.common.DSACoder;

/**
 * Application Lifecycle Listener implementation class InitListener
 * 
 */
public class InitListener implements ServletContextListener {

	protected static Log log = LogFactory.getLog(InitListener.class);

	private WebApplicationContext wac;

	private ServletContext servletContext;
	
	
	/**
	 * Default constructor.
	 */
	public InitListener() {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent contextEvent) {

		try {
			servletContext = contextEvent.getServletContext();

			Properties p = new Properties();

			p.load(InitListener.class.getClassLoader().getResourceAsStream("license.properties"));

			String sign = p.getProperty("sign");

			String publicKey = p.getProperty("publicKey");

			String data = p.getProperty("License");

			if (DSACoder.verify(data.getBytes(), publicKey, sign)) {

			} else {
				throw new Exception("license 文件非法");
			}

			wac = WebApplicationContextUtils.getWebApplicationContext(contextEvent.getServletContext());

			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		
	}

}
