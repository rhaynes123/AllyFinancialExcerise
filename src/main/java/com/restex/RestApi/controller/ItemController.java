package com.restex.RestApi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restex.RestApi.Exception.ResourceNotFoundException;
import com.restex.RestApi.entity.Bid;
import com.restex.RestApi.entity.Item;
import com.restex.RestApi.repo.BidRepository;
import com.restex.RestApi.repo.ItemRepository;
@Configuration
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1")
@RestController
public class ItemController {
	@Autowired
	ItemRepository itemrepo;
	//BidRepository	bidrepo;

	// 1. 
	@GetMapping("listitems")
	public List<Item> listAll() {
		return itemrepo.findAll();
	}
	// 2. 
		@GetMapping("item/{id}")
		public Optional<Item> listAllById(@PathVariable(value = "id") Integer itemId) {
			return itemrepo.findById(itemId);
		}
/*
	@GetMapping("listbids")
	public List<Bid> listAllBids() {
		return bidrepo.findAll();
	}*/

	
	
 @PostMapping("item")
    public Item createItem(@Valid @RequestBody Item item) {
        return itemrepo.save(item);
    }
 /*	 Used the below example curl to test the mysql trigger to track the bids worked as expected.
  *  Example Curl :curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "description": "Rare cup", "reservePrice": 35}' http://localhost:3000/api/v1/item/1
*/

    @PutMapping("item/{id}")
    public ResponseEntity<Item> updatedItem(@PathVariable(value = "id") Integer itemId,
         @Valid @RequestBody Item itemDetails) throws ResourceNotFoundException {
        Item item = itemrepo.findById(itemId)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));
        item.setId(itemDetails.getId());
        item.setDescription(itemDetails.getDescription());
        item.setReservePrice(itemDetails.getReservePrice());
        final Item updatedItem = itemrepo.save(item);
        return ResponseEntity.ok(updatedItem);
        }
    
}
