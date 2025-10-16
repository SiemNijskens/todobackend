package siem.todolist.DTOs.Tasks;

import jakarta.validation.constraints.NotBlank;
import siem.todolist.models.Color;
import siem.todolist.models.Status;
import siem.todolist.models.Task;

public record TaskUpdateDTO(
        @NotBlank(message = "Task is required")
        String task,
        Status status,
        Color color

) {

    public void updateEntity(Task task) {
        task.setTask(this.task);
        task.setStatus(this.status);
        task.setColor(this.color);
    }
}
