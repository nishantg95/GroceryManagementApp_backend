/**
 *
 */
package com.nishant.configurations;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <p>
 * This class extends AbstractAnnotationConfigDispatcherServletInitializer to
 * use Spring configuration defined in AppConfig.java
 * </p>
 *
 * @author nishant.b.grover
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/***
	 * <p>
	 * Sets root config class to AppConfig.class
	 * </p>
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	/***
	 * <p>
	 * Sets the Servlet Config class to null
	 * </p>
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/***
	 * <p>
	 * Adds Servlet mappings
	 * </p>
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
