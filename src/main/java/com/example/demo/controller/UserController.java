package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repos.UserRepository;

@RestController
public class UserController {

	@Autowired()
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() throws Exception{
		List<User> usersList = new ArrayList<User>();
		 usersList = userRepository.findAll();
		if(usersList.isEmpty()) {
			//return new ResponseEntity<List<User>>(usersList, HttpStatus.NO_CONTENT);
			throw new UserNotFoundException("No users found");
		}
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long userId){
		User user =  userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("Requested user not found with id :"+userId));
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public String saveUser(@RequestBody User user) {
		User u = userRepository.save(user);
		if(u!=null) {
			return "User has been saved successfully - with Id# :"+u.getId();
		}
		return "Unable to save the user info!";
	}
	
	@PutMapping("/users")
	public String updateUser(@RequestBody User user) {
		User currentUser = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("Unable to find the user to update the requested information for -"+user.getId()));
		 
			currentUser.setCity(user.getCity());
			currentUser.setEmail(user.getEmail());
			currentUser.setUsername(user.getUsername());
			User u = userRepository.save(currentUser);
			if(u !=null)
				return "User has been saved successfully - with Id# :"+u.getId();
			else
				return "Unable to save the user!";
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") Long userId){
			try{
				User u = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Unable to delete the requested user {}"+userId));
				if(u!=null) {
					userRepository.deleteById(userId);
					return new ResponseEntity<String>("User has been deleted successfull !", HttpStatus.OK);
				}else {
					return new ResponseEntity<Object> ( new UserNotFoundException("Unable to delete the requested user - "+userId), HttpStatus.OK);
				}
				
			}catch (Exception e) {
				throw new UserNotFoundException("User not found with : "+userId);
			}
		
	}
	
	@DeleteMapping("/users")
	public ResponseEntity deleteAllUsers(){
			try{
				userRepository.deleteAll();
				return new ResponseEntity<String>("User has been deleted successfull !", HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>( new UserNotFoundException("Internal server error, please try again!!"), HttpStatus.OK);
			}
		
	}
	
}
