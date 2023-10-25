package com.hq.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hq.backend.entity.ToDo;

@Service
public class ToDoService {
	
	// due to time constraints not creating todo list in derby DB, instead creating a singleton list here
	
	private List<ToDo> todos = new ArrayList<>();
	
	// again this can be an auto generated counter when doing it using JPA to generate id for todo item.
	private long counter = 0;
	

	public List<ToDo> listAll() {
		return todos;
	}

	public boolean addTodo(ToDo todo) {	
		todo.setId(++counter);
		return todos.add(todo);
	}

	public boolean deleteTodo(long id) {
		return todos.removeIf(t -> t.getId() == id) ;		
	}

	public boolean deleteAll() {
		counter = 0;	
		return todos.removeAll(todos);
	}

	public void updateTodo(long id, ToDo todo) {
		todos.stream()
		.filter(t -> (t.getId() == id))
		.findFirst()
		.ifPresent(t -> {
			t.setText(todo.getText()); 
			t.setDone(todo.isDone());
			});
	}

}
