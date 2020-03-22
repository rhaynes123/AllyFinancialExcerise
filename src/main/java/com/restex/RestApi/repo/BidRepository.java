package com.restex.RestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restex.RestApi.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Integer> {


}