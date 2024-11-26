package com.example.todo.service;

import com.example.todo.dao.ProjectDao;
import com.example.todo.dao.TodoDao;
import com.example.todo.model.Project;
import com.example.todo.model.ProjectRequest;
import com.example.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private TodoService todoService;

    public List<Project> getAllProjects() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Return projects associated with the logged-in user's username
        return projectDao.findByUsername(username);
    }

    public ResponseEntity<String> addProject(Project project) {
        projectDao.save(project);
        return new ResponseEntity<>("Project created successfully!",HttpStatus.CREATED);
    }

    public void deleteProject(Long id) {
        Optional<Project> project = projectDao.findById(id);
        project.ifPresent(value -> projectDao.delete(value));
    }

    public ResponseEntity<Project> getAllProjectsDetailsById(Long id) {
//        List<Todo> todos = todoService.getAllTodosByProject(id);
        Optional<Project> project = projectDao.findById(id);
        return new ResponseEntity<>(project.get(), HttpStatus.OK);
    }

    public ResponseEntity<String> updateProject(Long id, ProjectRequest request) {
        Optional<Project> project = projectDao.findById(id);
        try {
            Project project1 = project.get();
            project1.setTitle(request.getTitle());
            projectDao.save(project1);
            return new ResponseEntity<>("Project updated successfully!",HttpStatus.OK);
        }catch (Exception e){}
        return new ResponseEntity<>("Bad request, Todo is not successfully updated",HttpStatus.BAD_REQUEST);
    }
}

