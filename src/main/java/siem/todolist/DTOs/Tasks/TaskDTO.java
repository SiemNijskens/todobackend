package siem.todolist.DTOs.Tasks;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import siem.todolist.models.Color;
import siem.todolist.models.Status;
import siem.todolist.models.Task;

public record TaskDTO(
        @Id
        Long id,
        @NotBlank(message = "Task is required")
        String task,
        Status status,
        Color color
) {

    public static TaskDTO fromEntity(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTask(),
                task.getStatus(),
                task.getColor()
        );
    }
}
