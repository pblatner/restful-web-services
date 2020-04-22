package com.pjblat.springboot.rest.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public CollectionModel<EntityModel<User>> retrieveAllUsers() 
	{
		List<User> users = service.findAll();
		//List<EntityModel<User>> emUsers = new ArrayList<EntityModel<User>>();
		
		/*
		// Old School way of building the list of EntityModel objects using iteration
		for (Iterator iterator = users.iterator(); iterator.hasNext();) 
		{
			User user = (User) iterator.next();
			emUsers.add(
					new EntityModel<User>(
							user, 
							linkTo(methodOn(UserResource.class).retrieveUser(user.getId())).withSelfRel(),
							linkTo(methodOn(UserResource.class).retrieveAllUsers()).withRel("users"))
					);
		}
		*/
		
		// New School way to build the List of Entity Models using streams and a lambda function.
		// Sample from https://spring.io/guides/tutorials/rest/
		List<EntityModel<User>> emUsers = users.stream().map(user -> new EntityModel<>(user, 
				linkTo(methodOn(UserResource.class).retrieveUser(user.getId())).withSelfRel(),
				linkTo(methodOn(UserResource.class).retrieveAllUsers()).withRel("users"))
				).collect(Collectors.toList());
		
		
		return new CollectionModel<>(emUsers,
			    linkTo(methodOn(UserResource.class).retrieveAllUsers()).withSelfRel());

	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) 
	{
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		// hateoas
		// add links to the current object and /retrieveAllUsers method
		// Sample from https://spring.io/guides/tutorials/rest/
		return new EntityModel<>(
				user, 
				linkTo(methodOn(UserResource.class).retrieveUser(id)).withSelfRel(),
				linkTo(methodOn(UserResource.class).retrieveAllUsers()).withRel("users"));
		// return user;
	}

	// input - details of user
	// output - CREATED and return the created URI
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		// return CREATED status
		// return the URI of the created object
		// /users/{id}    - savedUser.getId()
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();	
		
		// return new ResponseEntity<>(location, HttpStatus.CREATED);
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) 
	{
		User user = service.deleteById(id);
		
		if (user == null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
}
