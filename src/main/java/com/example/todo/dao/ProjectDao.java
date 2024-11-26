package com.example.todo.dao;

import com.example.todo.model.Project;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProjectDao extends JpaRepository<Project,Long> {
    List<Project> findByUsername(String username);
}

