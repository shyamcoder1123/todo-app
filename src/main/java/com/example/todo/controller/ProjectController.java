package com.example.todo.controller;

import com.example.todo.model.Project;
import com.example.todo.model.ProjectRequest;
import com.example.todo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getAllProjectsDetails(@PathVariable Long id) {
        return projectService.getAllProjectsDetailsById(id);
    }

    @PostMapping
    public ResponseEntity<String> addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateProject(@PathVariable Long id, @RequestBody ProjectRequest request) {
        return projectService.updateProject(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project deleted successfully!");
    }
}

