package com.restex.RestApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restex.RestApi.entity.Bid;
import com.restex.RestApi.repo.BidRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class BidController {
	BidRepository	bidrepo;
	
	@GetMapping("listbids")
	public List<Bid> listAll() {
		return bidrepo.findAll();
	}

}
