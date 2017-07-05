package com.propulsion.yelp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.propulsion.yelp.domain.Restaurant;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql("/test_data.sql")
public class RestaurantRepositoryTests {
	
    @Autowired
    RestaurantRepository repository;
    
    @Test
    public void count() {
        assertThat(repository.count()).isEqualTo(1);
    }
    
    @Test
    public void findByNameContaining() {
    	List<Restaurant> restaurants = repository.findByNameContaining("Pet");
    	assertThat(restaurants.size()).isEqualTo(1);
    	assertThat(restaurants.get(0).getName()).isEqualTo("Petra");
    	assertThat(restaurants.stream()
    				.map(e -> e.getName())
    				.allMatch( e -> e.equals("Petra")));
    }
    
    @Test
    public void findAll() {
        assertThat(repository.findAll().size()).isEqualTo(1);
        assertThat(repository.findAll().get(0).getId()).isEqualTo(3);
    }

    
    @Test
    public void findById() {
    	Restaurant restaurant = repository.findById(3L);
        assertThat(restaurant.getId()).isEqualTo(3);
    }
 
}
