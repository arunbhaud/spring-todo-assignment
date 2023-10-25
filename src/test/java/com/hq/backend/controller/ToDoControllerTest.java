package com.hq.backend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hq.backend.entity.ToDo;
import com.hq.backend.service.ToDoService;

	
@WebMvcTest(ToDoController.class)
class ToDoControllerTest {
	
	@Autowired private MockMvc mockMvc;
    
    @Autowired private ObjectMapper objectMapper;
     
    @MockBean private ToDoService service;

    @Test
    public void testAddToDoSuccess() throws Exception {
    	ToDo todo1 = new ToDo(1, "Excercise", false);
    	
 
        String requestBody = objectMapper.writeValueAsString(todo1);
        
        when(service.addTodo(any())).thenReturn(true);
 
        mockMvc.perform(post("/todo").contentType("application/json")
                .content(requestBody))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void testAddToDoFailure() throws Exception {
    	ToDo todo1 = new ToDo(1, "Excercise", false);
    	
 
        String requestBody = objectMapper.writeValueAsString(todo1);
        
        when(service.addTodo(any())).thenReturn(false);
 
        mockMvc.perform(post("/todo").contentType("application/json")
                .content(requestBody))
                .andExpect(status().isBadRequest());
    }

}
