package com.example.springworld.controllers;

import com.example.springworld.data.Todo;
import com.example.springworld.service.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class TodoControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    void getAllTodos() throws Exception {
        List<Todo> todoList = Lists.list(new Todo(1, "item"), new Todo(2, "item"));

        when(toDoService.findAll()).thenReturn(todoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$",hasSize(2))).andDo(print());
    }

    @Test
    void saveATodoItem() throws Exception {
        Todo sampleTodo = new Todo(1, "Sample");

        when(toDoService.addTodo(any(Todo.class))).thenReturn(sampleTodo);

        ObjectMapper objectMapper = new ObjectMapper();
        String stringTodo = objectMapper.writeValueAsString(sampleTodo);

        ResultActions resultActions = mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(stringTodo)
        );

        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.item").value("Sample"));
    }
}
