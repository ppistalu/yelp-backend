package com.propulsion.yelp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import com.propulsion.yelp.domain.User;
import com.propulsion.yelp.service.UserService;

@RestController
@RequestMapping("/api")
public class RestUserController {
	
	private final UserService userService;
	
	@Autowired
	public RestUserController(UserService userService){
		this.userService = userService;
	}

	//update User anonymous
	@PutMapping("/user/{id}")
	@ResponseStatus(NO_CONTENT)
	public void updateuser(@RequestBody String firstName,String lastName, 
							Long userId, @PathVariable Long id){
		userService.updateUserById(firstName, lastName, userId);
	}
	
//	//sign-up User
//	@PostMapping("/users/sign_up")
//	public Ht createUser (@RequestBody User postedUser){
//		User savedUser = userService.save(postedUser);
//		
//		//this is like building the url (to tell it how to find the new user)
//        UriComponents uriComponents = fromMethodCall(on(getClass()).userService.findById(savedUser.getId())).build();
//        //this is turning the url into string
//        return ResponseEntity.created(uriComponents.encode().toUri()).build();
//	}
}


