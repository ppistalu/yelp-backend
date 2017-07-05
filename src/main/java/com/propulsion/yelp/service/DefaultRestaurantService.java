package com.propulsion.yelp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.Restaurant;
import com.propulsion.yelp.repository.RestaurantRepository;

@Transactional(readOnly = true)
@Service
public class DefaultRestaurantService implements RestaurantService {

	private final RestaurantRepository restaurantRepository;
	
	@Autowired
    public DefaultRestaurantService (RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
	
	@Override
	public List<Restaurant> findAll() {
		return this.restaurantRepository.findAll();
	}

	@Override
	public Restaurant findById(Long id) {
		return this.restaurantRepository.findById(id);
	}

	@Override
	public List<Restaurant> findByNameContaining(String name) {
		return this.restaurantRepository.findByNameContaining(name);
	}

}
