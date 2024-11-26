package com.example.todo.model;

import lombok.Data;

@Data
public class TodoRequest {
    private Long id;
    private String description;
    private boolean completed;
    private Long projectId;
}

