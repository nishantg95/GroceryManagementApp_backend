package com.nishant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nishant.managers.ItemManager;
import com.nishant.models.Item;

@RestController
@RequestMapping(value = "/data/items")
public class ItemRestController {

@Autowired
ItemManager itemManager;


    //-------------------Retrieve All Items--------------------------------------------------------
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> listAllItems() {
        List<Item> items = itemManager.findAllItems();
        System.out.println("From ItemRestController"+items);
        if(items.isEmpty()){
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
    
    //-------------------Retrieve Single Item--------------------------------------------------------
    
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("id") Integer id) {
        System.out.println("Fetching Item with id " + id);
        Item item = itemManager.findById(id);
        if (item == null) {
            System.out.println("Item with id " + id + " not found");
            return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
  
    
    
    //-------------------Create a Item--------------------------------------------------------
    
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public ResponseEntity<Void> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Item " + item.getName());
        
        if (itemManager.isItemExist(item)) {
		  System.out.println("A Item with name " + item.getName() + " already exist");
		  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		  
        }
		   
        itemManager.saveItem(item);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------------- Update a Item --------------------------------------------------------
    
    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        System.out.println("Updating Item " + id);
          
        Item currentItem = itemManager.findById(id);
          
        if (currentItem==null) {
            System.out.println("Item with id " + id + " not found");
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        
        itemManager.updateItem(item);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Item --------------------------------------------------------
      
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteItem(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting Item with id " + id);
  
        Item item = itemManager.findById(id);
        if (item == null) {
            System.out.println("Unable to delete. Item with id " + id + " not found");
            return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
        }
  
        itemManager.deleteItemById(id);
        return new ResponseEntity<Item>(HttpStatus.OK);
    }
  
      
     
    //------------------- Delete All Items --------------------------------------------------------
      
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteAllItems() {
        System.out.println("Deleting All Items");
  
        itemManager.deleteAllItems();
        return new ResponseEntity<Item>(HttpStatus.OK);
    }
    
    
}
