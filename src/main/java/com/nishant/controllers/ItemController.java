package com.nishant.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nishant.models.Item;

@Controller
public class ItemController {
	
	   @RequestMapping(value={"", "/", "index"}, method = RequestMethod.GET)
	   public String homePage() {
		   return "index";
	   }
	   
	
	   @RequestMapping(value = "/addItem", method = RequestMethod.GET)
	    public ModelAndView showForm() {
	        return new ModelAndView("itemForm", "item", new Item());
	    }
	 
	    @RequestMapping(value = "/viewItem", method = RequestMethod.POST)
	    public String submit(@Valid @ModelAttribute("item")Item item, 
	      BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "error";
	        }
	        model.addAttribute("name", item.getName());
	        model.addAttribute("expiry", item.getExpiry());
	        model.addAttribute("id", item.getId());
	        return "itemView";
	    }
	    
	    @RequestMapping(value = "/items" ,method = RequestMethod.GET)
	    public String userView() {
	    	return "userItemsView";
	    }
	    
	}
