package com.example.springworld.service;

import com.example.springworld.data.Todo;
import com.example.springworld.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ToDoServiceTest {
    @Autowired
    private TodoRepository todoRepository;

    @Test
    void getAllToDos() {
        ToDoService toDoService = new ToDoService(todoRepository);

        Todo sample = new Todo(1, "Sample");
        todoRepository.save(sample);

        List<Todo> todoList = toDoService.findAll();

        assertEquals(1, todoList.size());
    }

    @Test
    void saveATodo() {
        ToDoService toDoService = new ToDoService(todoRepository);

        Todo sample = new Todo(1, "Sample");
        toDoService.addTodo(sample);

        assertEquals(1, todoRepository.count());

    }

    @AfterEach
    void tearDown(){
        todoRepository.deleteAll();
    }

}