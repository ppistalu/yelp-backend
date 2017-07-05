package com.propulsion.yelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propulsion.yelp.domain.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	Restaurant findById(Long id);
	
	List<Restaurant> findByNameContaining(String name);


}
