package com.nishant.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nishant.models.Item;

@Controller
public class AppViewController {

	@RequestMapping(value = { "", "/", "welcome" }, method = RequestMethod.GET)
	public String homePage() {
		return "welcome";
	}

	@RequestMapping(value = "/addItemForm", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addItemForm", "item", new Item());
	}

	@RequestMapping(value = "/viewItem", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("item") Item item, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("name", item.getName());
		model.addAttribute("expiry", item.getExpiry());
		model.addAttribute("id", item.getId());
		return "itemView";
	}

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String userView() {
		return "inventory";
	}

}
