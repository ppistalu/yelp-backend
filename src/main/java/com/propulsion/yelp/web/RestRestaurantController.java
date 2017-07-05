package com.propulsion.yelp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.propulsion.yelp.domain.JsonViews;
import com.propulsion.yelp.domain.Restaurant;
import com.propulsion.yelp.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestRestaurantController {
	
	private final RestaurantService restaurantService;

	@Autowired
	public RestRestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	
	@JsonView(JsonViews.Summary.class)
	@GetMapping
	public List<Restaurant> retreiveAllRestaurants(){
		return restaurantService.findAll();
	}
	
	@JsonView(JsonViews.Details.class)
	@GetMapping("/{id}")
	public Restaurant retrieveRestaurants(@PathVariable Long id) {
		Restaurant res = restaurantService.findById(id);
		System.out.println(res.getReviews());
		return restaurantService.findById(id);
	}
	
	@JsonView(JsonViews.Summary.class)
	@RequestMapping(value = "/search", params = "query", method=RequestMethod.GET)
	public List<Restaurant> retrievereRestaurantsContaining(@RequestParam("query")  String name) {

		return restaurantService.findByNameContaining(name);
	}
	
	
}
