package com.example.todo.dao;

import com.example.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoDao extends JpaRepository<Todo, Long> {
    @Query(value = "select * " +
            "from todo" +
            " where project_id = :projectId",
            nativeQuery = true)
    List<Todo> findTodosByProjectId(Long projectId);
}
