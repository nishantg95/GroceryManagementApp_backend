package com.nishant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.nishant.managers.ItemManager;
import com.nishant.models.Item;

/***
 *
 * @author nishant.b.grover
 *
 */
@Controller
@RequestMapping(value = "/data")
public class ItemController {

	@Autowired
	private ItemManager itemManager;

	/***
	 *
	 * @param item
	 * @param ucBuilder
	 * @return
	 */

	@RequestMapping(value = "/createItem", method = RequestMethod.POST)
	public ResponseEntity<Void> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Item " + item.getName());

		if (this.itemManager.isItemExist(item)) {
			System.out.println("A Item with name " + item.getName() + " already exist");
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}

		this.itemManager.saveItem(item);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Item> deleteItem(@PathVariable("id") Integer id) {
		System.out.println("Fetching & Deleting Item with id " + id);

		Item item = this.itemManager.findById(id);
		if (item == null) {
			System.out.println("Unable to delete. Item with id " + id + " not found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		this.itemManager.deleteItemById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/getItem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getItem(@PathVariable("id") Integer id) {
		System.out.println("Fetching Item with id " + id);
		Item item = this.itemManager.findById(id);
		if (item == null) {
			System.out.println("Item with id " + id + " not found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@RequestMapping(value = "/listAllItems", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listAllItems(@RequestHeader HttpHeaders header) {
		System.out.println(header.get(HttpHeaders.USER_AGENT));
		List<Item> items = this.itemManager.findAllItems();
		System.out.println("From ItemRestController" + items);
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateItem/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Item> updateItem(@PathVariable("id") Integer id, @RequestBody Item item) {
		System.out.println("Updating Item " + id);

		Item currentItem = this.itemManager.findById(id);

		if (currentItem == null) {
			System.out.println("Item with id " + id + " not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		this.itemManager.updateItem(item);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

}
