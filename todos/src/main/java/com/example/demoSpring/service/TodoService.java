package com.example.demoSpring.service;

import com.example.demoSpring.model.Todo;
import com.example.demoSpring.model.TodoRequest;
import com.example.demoSpring.model.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getAllTodo();

    TodoResponse getTodoById(Long id);

    TodoResponse createTodo(TodoRequest todoRequest);

    TodoResponse updateTodoById(Long id, TodoRequest todoRequest);

    void deleteTodoById(Long id);
}
