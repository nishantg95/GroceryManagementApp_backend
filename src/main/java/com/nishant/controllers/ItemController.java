package com.nishant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.nishant.managers.ItemManager;
import com.nishant.views.ItemView;

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
	 * @param itemView
	 * @param ucBuilder
	 * @return ResponseEntity
	 */

	@RequestMapping(value = "/createItem", method = RequestMethod.POST)
	public ResponseEntity<Void> createItem(@RequestBody ItemView itemView, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Item " + itemView.getName());

		if (this.itemManager.isItemExist(itemView)) {
			System.out.println("A Item with name " + itemView.getName() + " already exist");
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}

		this.itemManager.saveItem(itemView);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/itemView/{id}").buildAndExpand(itemView.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

//
//	@RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<ItemView> deleteItem(@PathVariable("id") Integer id) {
//		System.out.println("Fetching & Deleting Item with id " + id);
//
//		ItemView itemView = this.itemManager.findById(id);
//		if (itemView == null) {
//			System.out.println("Unable to delete. Item with id " + id + " not found");
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//
//		this.itemManager.deleteItemById(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/getItem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ItemView> getItem(@PathVariable("id") Integer id) {
//		System.out.println("Fetching Item with id " + id);
//		ItemView itemView = this.itemManager.findById(id);
//		if (itemView == null) {
//			System.out.println("Item with id " + id + " not found");
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(itemView, HttpStatus.OK);
//	}
//
	@RequestMapping(value = "/listAllItems", method = RequestMethod.GET)
	public ResponseEntity<List<ItemView>> listAllItems(@RequestHeader HttpHeaders header) {
		System.out.println(header.get(HttpHeaders.USER_AGENT));
		List<ItemView> items = this.itemManager.findAllItems();
		System.out.println("From ItemRestController" + items);
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

//	@RequestMapping(value = "/updateItem/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<ItemView> updateItem(@PathVariable("id") Integer id, @RequestBody ItemView itemView) {
//		System.out.println("Updating Item " + id);
//
//		ItemView currentItem = this.itemManager.findById(id);
//
//		if (currentItem == null) {
//			System.out.println("Item with id " + id + " not found");
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		this.itemManager.updateItem(itemView);
//		return new ResponseEntity<>(itemView, HttpStatus.OK);
//	}

}
