package com.example.springworld.service;

import com.example.springworld.data.Todo;
import com.example.springworld.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final TodoRepository todoRepository;

    public ToDoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
