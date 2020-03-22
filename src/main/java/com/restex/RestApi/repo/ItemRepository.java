package com.restex.RestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restex.RestApi.entity.Item;



public interface ItemRepository extends JpaRepository<Item, Integer> {


}
