package com.example.demoSpring.service;

import com.example.demoSpring.client.CategoryClientService;
import com.example.demoSpring.exception.NotFoundException;
import com.example.demoSpring.model.*;
import com.example.demoSpring.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImp implements TodoService{
    private final TodoRepository todoRepository;
    private final CategoryClientService categoryClientService;

    public TodoServiceImp(TodoRepository todoRepository, CategoryClientService categoryClientService) {
        this.todoRepository = todoRepository;
        this.categoryClientService = categoryClientService;
    }

    @Override
    public List<TodoResponse> getAllTodo() {
        //get data form database
        List<Todo> todos = todoRepository.findAll();
        //add response for return
        //create to store todoResponse object;
        List<TodoResponse> todoResponses = new ArrayList<>();
        //loop list for get data from database
        for(Todo todo : todos){
            ResponseEntity<APIResponse<Category>> response = categoryClientService.getCategoryById(todo.getCategoryResponse());
            todoResponses.add(todo.toResponse(response.getBody().getPayload()));
        }
        return todoResponses;
    }


    @Override
    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Todo by id "+id+" not found")
        );
        ResponseEntity<APIResponse<Category>> response = categoryClientService.getCategoryById(todo.getCategoryResponse());
        return todo.toResponse(response.getBody().getPayload());
    }

    @Override
    public TodoResponse createTodo(TodoRequest todoRequest) {
        Todo todo = todoRepository.save(todoRequest.toEntity());
        ResponseEntity<APIResponse<Category>> response = categoryClientService.getCategoryById(todoRequest.getCategoryResponse());
        return todo.toResponse(response.getBody().getPayload());
    }

    @Override
    public TodoResponse updateTodoById(Long id, TodoRequest todoRequest) {
        getTodoById(id);
        Todo todo = todoRepository.save(todoRequest.toEntity(id));
        ResponseEntity<APIResponse<Category>> response = categoryClientService.getCategoryById(todo.getCategoryResponse());
        return todo.toResponse(response.getBody().getPayload());
    }

    @Override
    public void deleteTodoById(Long id) {
        getTodoById(id);
        todoRepository.deleteById(id);
    }
}
