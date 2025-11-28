package siem.todolist.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import siem.todolist.DTOs.Tasks.TaskCreateDTO;
import siem.todolist.DTOs.Tasks.TaskDTO;
import siem.todolist.DTOs.Tasks.TaskUpdateDTO;
import siem.todolist.services.TaskService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/task")
public class TaskController {

    final private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(
            @Valid @RequestBody TaskCreateDTO createDTO) {
        TaskDTO created = taskService.createTask(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskUpdateDTO updateDTO) {
        TaskDTO updated = taskService.updateTask(taskId, updateDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTask() {
        List<TaskDTO> tasks = taskService.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long taskId) {
        TaskDTO task = taskService.findById(taskId);
        return ResponseEntity.ok(task);
    }
}
