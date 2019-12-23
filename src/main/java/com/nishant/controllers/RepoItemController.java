/**
 *
 */
package com.nishant.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nishant.entities.RepoItemEntity;
import com.nishant.managers.RepoItemManager;

/**
 * @author nishant.b.grover
 *
 */
@Controller
@RequestMapping(value = "/repo")
public class RepoItemController {

	private static final Logger LOGGER = Logger.getLogger(RepoItemController.class.toString());

	@Autowired
	private RepoItemManager repoItemManager;

	@RequestMapping(value = "/listAllRepoItems", method = RequestMethod.GET)
	public ResponseEntity<List<RepoItemEntity>> listAllRepoItems() {
		List<RepoItemEntity> repoItems = this.repoItemManager.findAllRepoItems();
		LOGGER.finer(String.valueOf(repoItems.size()));
		// TODO:implement isEmpty
//		if (repoItems.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity<>(repoItems, HttpStatus.OK);
	}
}
