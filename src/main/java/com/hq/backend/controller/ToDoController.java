package com.hq.backend.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hq.backend.entity.ToDo;
import com.hq.backend.service.ToDoService;	

@RestController
@ResponseBody
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	//list todo items
	@GetMapping("/todos")
	public List<ToDo> listTodos() {
		return toDoService.listAll();
	}
	
	//add todo item
	@PostMapping("/todo")
	public ResponseEntity<String> addTodo(@RequestBody ToDo todo) {
		if(toDoService.addTodo(todo)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("todo item created!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("creation failed!");
	}
	
	//update todo item
	@PutMapping("/todo/{id}")
	public void updateTodo(@RequestBody ToDo todo, @PathVariable long id) {
		toDoService.updateTodo(id, todo);
	}
	
	//delete a todo item
	@DeleteMapping("/todo/{id}")
	public String deleteTodo(@PathVariable long id) {
		if(!toDoService.deleteTodo(id)) {
			return "Delete FAILED!";
		}
		return "deleted successfully!";
	}
	
	//delete all todo items
	@DeleteMapping("/todos")
	public String deleteAllTodos() {
		if(!toDoService.deleteAll()) {
			return "DeleteAll FAILED!";
		}
		return "deleted ALL successfully!";
	}
	
	

}
