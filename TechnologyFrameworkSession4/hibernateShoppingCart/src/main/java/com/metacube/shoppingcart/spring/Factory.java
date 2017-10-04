package com.metacube.shoppingcart.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * The Class Factory.
 * 
 */
public class Factory {
	
	/** The application context. */
	static ApplicationContext applicationContext;

	static {
		System.out.println("In factory");
		applicationContext = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}
}
