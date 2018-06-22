package com.restex.RestDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restex.RestDemo.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByCategory(String category);

	List<Movie> findByTitle(String title);
	
	List<Movie> findByTitleContaining(String word);

}
