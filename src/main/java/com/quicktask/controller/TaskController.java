package com.quicktask.controller;

import com.quicktask.model.Task;
import com.quicktask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // React ke liye CORS
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    // Create task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // Update task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setCompleted(updatedTask.isCompleted());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    updatedTask.setId(id);
                    return taskRepository.save(updatedTask);
                });
    }

    // Delete task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
