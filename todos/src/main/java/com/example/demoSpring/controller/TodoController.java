package com.example.demoSpring.controller;

import com.example.demoSpring.model.APIResponse;
import com.example.demoSpring.model.Todo;
import com.example.demoSpring.model.TodoRequest;
import com.example.demoSpring.model.TodoResponse;
import com.example.demoSpring.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<TodoResponse>>>getAllTodo(){
        List<TodoResponse> todos = todoService.getAllTodo();
        APIResponse<List<TodoResponse>> apiResponse = APIResponse.<List<TodoResponse>>builder()
                .message("Get all todos successfully!")
                .status(HttpStatus.OK)
                .payload(todos)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<TodoResponse>>getTodoById(@PathVariable Long id){
        TodoResponse todo = todoService.getTodoById(id);
        APIResponse<TodoResponse> apiResponse = APIResponse.<TodoResponse>builder()
                .message("Get todos by id successfully!")
                .status(HttpStatus.OK)
                .payload(todo)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping
    public ResponseEntity<APIResponse<TodoResponse>>createTodo(@RequestBody TodoRequest todoRequest){
        TodoResponse todos = todoService.createTodo(todoRequest);
        APIResponse<TodoResponse> apiResponse = APIResponse.<TodoResponse>builder()
                .message("Created todos successfully!")
                .status(HttpStatus.OK)
                .payload(todos)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<TodoResponse>>updateTodoById(@PathVariable Long id , @RequestBody TodoRequest todoRequest){
        TodoResponse todos = todoService.updateTodoById(id , todoRequest);
        APIResponse<TodoResponse> apiResponse = APIResponse.<TodoResponse>builder()
                .message("Updated todos by id successfully!")
                .status(HttpStatus.OK)
                .payload(todos)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<TodoResponse>>deleteTodoById(@PathVariable Long id){
        todoService.deleteTodoById(id);
        APIResponse<TodoResponse> apiResponse = APIResponse.<TodoResponse>builder()
                .message("Deleted todos by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
