package com.example.springworld.controllers;

import com.example.springworld.service.ToDoService;
import com.example.springworld.data.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/todos")
    ResponseEntity<Todo> addTodos(@Valid @RequestBody Todo todo){
        return new ResponseEntity<>(toDoService.addTodo(todo),HttpStatus.CREATED);
    }
}
