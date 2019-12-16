package com.nishant.controllers;

import java.util.List;
import java.util.logging.Logger;

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
import com.nishant.views.ItemView;

/***
 * <p>
 * This Spring controller sets URL's to perform CRUD operations on /data URL for
 * item model
 * </p>
 *
 * @author nishant.b.grover
 *
 */
@Controller
@RequestMapping(value = "/data")
public class ItemController {

	private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

	@Autowired
	private ItemManager itemManager;

	/***
	 * <p>
	 * Performs Create operation for Item Entity
	 * </p>
	 *
	 * @param itemView
	 * @param ucBuilder
	 * @return ResponseEntity
	 */

	@RequestMapping(value = "/createItem", method = RequestMethod.POST)
	public ResponseEntity<Void> createItem(@RequestBody ItemView itemView, UriComponentsBuilder ucBuilder) {
		LOGGER.info("Creating Item " + itemView.getName());

		if (this.itemManager.isItemExist(itemView)) {
			LOGGER.info("A Item with name " + itemView.getName() + " already exist");
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}

		this.itemManager.saveItem(itemView);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/itemView/{id}").buildAndExpand(itemView.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	/***
	 * <p>
	 * Performs Delete operation for Item Entity for the specified ID supplied by
	 * PathVariable
	 * </p>
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ItemView> deleteItem(@PathVariable("id") Integer id) {
		LOGGER.info("Fetching & Deleting Item with id " + id);

		ItemView itemView = this.itemManager.findById(id);
		if (itemView == null) {
			LOGGER.info("Unable to delete. Item with id " + id + " not found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		this.itemManager.deleteItemById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/***
	 * <p>
	 * Performs Read operation for Item Entity for the specified ID supplied by
	 * PathVariable
	 * </p>
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getItem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemView> getItem(@PathVariable("id") Integer id) {
		LOGGER.info("Fetching Item with id " + id);
		ItemView itemView = this.itemManager.findById(id);
		if (itemView == null) {
			LOGGER.info("Item with id " + id + " not found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(itemView, HttpStatus.OK);
	}

	/***
	 * <p>
	 * Fetches all objects as an array list for for the item entity
	 * </p>
	 *
	 * @param header
	 * @return
	 */
	@RequestMapping(value = "/listAllItems", method = RequestMethod.GET)
	public ResponseEntity<List<ItemView>> listAllItems(@RequestHeader HttpHeaders header) {
		LOGGER.info(header.get(HttpHeaders.USER_AGENT).toString());
		List<ItemView> items = this.itemManager.findAllItems();
		LOGGER.info("From ItemRestController" + items);
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	/***
	 * Performs Update operation for Item Entity for the specified ID supplied by
	 * PathVariable
	 *
	 * @param id
	 * @param itemView
	 * @return
	 */
	@RequestMapping(value = "/updateItem/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ItemView> updateItem(@PathVariable("id") Integer id, @RequestBody ItemView itemView) {
		LOGGER.info("Updating Item " + id);

		ItemView currentItem = this.itemManager.findById(id);

		if (currentItem == null) {
			LOGGER.info("Item with id " + id + " not found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		this.itemManager.updateItem(itemView);
		return new ResponseEntity<>(itemView, HttpStatus.OK);
	}

}
