package com.restex.RestDemo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restex.RestDemo.entity.Movie;
import com.restex.RestDemo.repo.MovieRepository;

@RestController
public class MovieController {
	@Autowired
	MovieRepository mr;

	// 1. 
	@GetMapping("listmovies")
	public List<Movie> listAll() {
		return mr.findAll();
	}

	// 2.
	@GetMapping("categorysearch")
	public List<Movie> findByCat(@RequestParam("cat") String category) {
		return mr.findByCategory(category);
	}

	// 3.
	@GetMapping("randommovie")
	public Movie random() {
		int rand = (int)(Math.random() * mr.findAll().size()) +1 ;
		return mr.getOne(rand);
	}
	
	// 4.
	@GetMapping("randomcat")
	public Movie randomCategory(@RequestParam("cat") String category) {
		List<Movie> randCat = mr.findByCategory(category);
		int rand = (int)(Math.random() * randCat.size()) ;
		return randCat.get(rand);
	}
	
	// 5. 
	@GetMapping("randomlist")
	public List<Movie> randomList(@RequestParam("num") int number) {
		List<Movie> mList= mr.findAll();
		Collections.shuffle(mList);
		return mList.subList(0, number);
	}
	
	// 6.
	@GetMapping("categorylist")
	public List<String> categoryList() {
		List<String> categoryList = new ArrayList<>();
		for (Movie m : mr.findAll()) {
			if (!categoryList.contains(m.getCategory())) {
			categoryList.add(m.getCategory());
			}
		}
		return categoryList;
	}
	
	// 7. 
	@GetMapping("titlesearch")
	public List<Movie> findByTitle(@RequestParam("title") String title) {
		return mr.findByTitle(title);
	}
	
	// 8. 
	@GetMapping("titlekeyword")
	public List<Movie> findByTitleKeyword(@RequestParam("word") String word) {
		return mr.findByTitleContaining(word);
	}
	
}
