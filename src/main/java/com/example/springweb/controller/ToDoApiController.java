package com.example.springweb.controller;

import com.example.springweb.domain.ToDo;
import com.example.springweb.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class ToDoApiController {
    private final ToDoService toDoService;

    @GetMapping
    public ResponseEntity<?> todos() {
        List<ToDo> toDoList = toDoService.getToDoList();
        return ResponseEntity.ok(toDoList);
    }

    @PostMapping
    public ResponseEntity<?> addTodo(@RequestBody ToDo todo){
        toDoService.addToDo(todo.getTodo());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id){
        toDoService.deleteToDoById(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping
    public ResponseEntity<?> updateTodo(@RequestBody ToDo todo){
        toDoService.updateToDo(todo);
        return ResponseEntity.ok().build();
    }
}
