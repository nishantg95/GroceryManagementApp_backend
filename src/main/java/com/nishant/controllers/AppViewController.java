package com.nishant.controllers;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nishant.entities.ItemEntity;
import com.nishant.views.ItemView;

/***
 * <p>
 * Controller class to bind models and views to URL's that do not
 * perform/request a Hibernate transaction. This controller is also responsible
 * for Asynchronous submission
 * </p>
 *
 * @author nishant.b.grover
 *
 */
@Controller
public class AppViewController {

	private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

	/***
	 * <p>
	 * This function returns the name of jsp view to be binded for index page
	 * </p>
	 *
	 * @return
	 */
	@RequestMapping(value = { "", "/", "welcome" }, method = RequestMethod.GET)
	public String homePage() {
		return "welcome";
	}

	/***
	 * <p>
	 * This function returns a ModelAndView object to map Async request
	 * </p>
	 *
	 * @return
	 */
	@RequestMapping(value = "/addItemForm", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addItemForm", "item", new ItemView());
	}

	/***
	 * <p>
	 * This function receives a ItemEntity object
	 * </p>
	 *
	 * @param item
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewItem", method = RequestMethod.POST)
	public ModelAndView submit(@Valid @ModelAttribute("item") ItemEntity item) {
		ItemView itemView = new ItemView();
		BeanUtils.copyProperties(item, itemView);
		LOGGER.info(itemView.toString());
		return new ModelAndView("itemView", "item", itemView);
	}

	/***
	 * <p>
	 * Sets the URL and view for user inventory view
	 * </p>
	 *
	 * @return
	 */
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String userView() {
		return "inventory";
	}

}
