package com.nishant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nishant.models.Item;
import com.nishant.services.ItemService;
@RestController
@RequestMapping(value = "/data/items")
public class ItemRestController {
	@Autowired
	ItemService itemService;
    //-------------------Retrieve All Items--------------------------------------------------------
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> listAllItems() {
        List<Item> items = itemService.findAllItems();
        System.out.println("From ItemRestController"+items);
        if(items.isEmpty()){
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
    //-------------------Create a Item--------------------------------------------------------
    
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public ResponseEntity<Void> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Item " + item.getName());
  
        if (itemService.isItemExist(item)) {
            System.out.println("A Item with name " + item.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        itemService.saveItem(item);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
