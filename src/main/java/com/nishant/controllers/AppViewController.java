package com.nishant.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nishant.entities.ItemEntity;
import com.nishant.models.ItemModel;
import com.nishant.views.ItemView;

@Controller
public class AppViewController {

	@RequestMapping(value = { "", "/", "welcome" }, method = RequestMethod.GET)
	public String homePage() {
		return "welcome";
	}

	@RequestMapping(value = "/addItemForm", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addItemForm", "item", new ItemView());
	}

	@RequestMapping(value = "/viewItem", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("item") ItemEntity item, BindingResult result, ModelMap model) {
		ItemView itemView = new ItemView();
		BeanUtils.copyProperties(item, itemView);
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("name", itemView.getName());
		model.addAttribute("shelfLife", itemView.getShelfLife());
		model.addAttribute("id", itemView.getId());
		return "itemView";
	}

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String userView() {
		return "inventory";
	}

}
