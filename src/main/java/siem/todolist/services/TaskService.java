package siem.todolist.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siem.todolist.DTOs.Tasks.TaskCreateDTO;
import siem.todolist.DTOs.Tasks.TaskDTO;
import siem.todolist.DTOs.Tasks.TaskUpdateDTO;
import siem.todolist.models.Task;
import siem.todolist.respositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    final private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO createTask(TaskCreateDTO createDTO) {
        Task task = createDTO.toEntity();
        Task savedTask = taskRepository.save(task);
        return TaskDTO.fromEntity(savedTask);
    }

    public TaskDTO updateTask(Long taskId, TaskUpdateDTO updateDTO) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new EntityNotFoundException("task with ID: " + taskId + " not found"));
            updateDTO.updateEntity(task);
            Task savedTask = taskRepository.save(task);
            return TaskDTO.fromEntity(savedTask);
    }

    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("task with ID: " + taskId + " not found"));
        taskRepository.deleteById(taskId);
    }

    public List<TaskDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskDTO::fromEntity)
                .toList();
    }

    public TaskDTO findById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("task with ID: " + taskId + " not found"));
        return TaskDTO.fromEntity(task);
    }
}
