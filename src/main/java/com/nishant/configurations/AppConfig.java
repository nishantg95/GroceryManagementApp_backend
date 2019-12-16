/**
 *
 */
package com.nishant.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * <p>
 * This class extends WebMvcConfigurerAdapter to set various aspects of Spring
 * MVC environment such as adding resource handlers, scan base packages and
 * configure view resolver.
 * </p>
 *
 * @author nishant.b.grover
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nishant")
public class AppConfig extends WebMvcConfigurerAdapter {

	/***
	 * <p>
	 * Adds resource handlers based on ResourceHandlerRegistry parameter
	 * </p>
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	/***
	 * <p>
	 * Sets View resolvers based on ViewResolverRegisty parameter
	 * </p>
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}

}
