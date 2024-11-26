package com.example.todo.service;

import com.example.todo.dao.ProjectDao;
import com.example.todo.dao.TodoDao;
import com.example.todo.model.Project;
import com.example.todo.model.Todo;
import com.example.todo.model.TodoRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private ProjectDao projectDao;

    public List<Todo> getAllTodosByProject(Long id) {
        return todoDao.findTodosByProjectId(id);
    }

    public ResponseEntity<String> createTodo(String description, boolean completed, Long projectId) {
        // Retrieve the associated project
        try {
            Optional<Project> project1 = projectDao.findById(projectId);
            Project project = project1.get();

            Todo todo = new Todo();
            todo.setDescription(description);
            todo.setCompleted(completed);
            todo.setCreatedDate(new Date());
            todo.setUpdatedDate(new Date());
            todo.setProject(project);
            todoDao.save(todo);
            return new ResponseEntity<>("The "+todo.getDescription()+ " successfully added", HttpStatus.CREATED);
        }catch (Exception e){
        }
        return new ResponseEntity<>("Bad request, Todo is not successfully added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateTodo(Long todoId, String description, boolean completed, Long projectId) {

        try {
            Todo todo = todoDao.findById(todoId)
                    .orElseThrow(() -> new EntityNotFoundException("Todo with ID " + todoId + " not found"));
            todo.setDescription(description);
            todo.setCompleted(completed);
            todo.setUpdatedDate(new Date());
            todoDao.save(todo);
            return new ResponseEntity<>("The "+todo.getDescription()+ " successfully updated", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Bad request, Todo is not successfully updated",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteTodo(Long id) {
        try {
            todoDao.deleteById(id);
            return new ResponseEntity<>("Todo successfully deleted", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the Todo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

