package com.example.todo.controller;
import com.example.todo.model.Todo;
import com.example.todo.model.TodoRequest;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodosByProject(@RequestParam Long projectId) {
        return todoService.getAllTodosByProject(projectId);
    }
    @PostMapping
    public ResponseEntity<String> createTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.createTodo(
                todoRequest.getDescription(),
                todoRequest.isCompleted(),
                todoRequest.getProjectId()
                );
    }
    @PutMapping
    public ResponseEntity<String> updateTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.updateTodo(
                todoRequest.getId(),
                todoRequest.getDescription(),
                todoRequest.isCompleted(),
                todoRequest.getProjectId()
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        return todoService.deleteTodo(id);
    }
}