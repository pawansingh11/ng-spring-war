package com.springdemo.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	
	static{
		todos.add(new Todo(++idCounter,"pawan","dance",new Date(), false));
		todos.add(new Todo(++idCounter,"singh","cfd",new Date(), true));
		todos.add(new Todo(++idCounter,"adc","adc",new Date(), false));
		todos.add(new Todo(++idCounter,"pcfsawan","sdcf",new Date(), true));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id){
		Todo todo = findById(id);
		if(todo==null){
			return null;
		}
		if(todos.remove(todo)){
			return todo;
		}
		
		return null;
	}

	private Todo findById(long id) {
		for(Todo todo:todos){
			if(todo.getId() == id){
				return todo;
			}
		}
		return null;
	}
	
//	here save method can add todo or update todo
//	if it is add then there won't be any id i.e id==-1||0 if there is id then it is update
	public Todo save(Todo todo){
		if(todo.getId()==-1 || todo.getId()==0){
			todo.setId(++idCounter);
			todos.add(todo);
			
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
}
