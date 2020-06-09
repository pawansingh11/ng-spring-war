package com.springdemo.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springdemo.rest.webservices.restfulwebservices.todo.Todo;

@CrossOrigin("*")
@RestController
public class TodoResources {
//	this is similar to dependency injection in angular to manage all dependencies
	@Autowired
	private TodoHardCodedService todoService;
	
//	@GetMapping("/")
//	public String index() {
//	    return "/index.html";
//	}
	
	@GetMapping("/api/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
//	here we are using response entity to return succes or error response
	@DeleteMapping("/api/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodO(@PathVariable String username, @PathVariable long id){
		Todo todo = todoService.deleteById(id);
		
//		if delete was successful we will send response of no content
		if(todo!=null){
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/api/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(
									@PathVariable String username, 
									@PathVariable long id,
									@RequestBody Todo todo
									){
		Todo todoUpdated = todoService.save(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/api/users/{username}/todos")
	public ResponseEntity<Todo> updateTodo(
									@PathVariable String username, 
									@RequestBody Todo todo
									){
		Todo createdTodo = todoService.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
