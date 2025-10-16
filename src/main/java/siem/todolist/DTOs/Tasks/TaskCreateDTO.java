package siem.todolist.DTOs.Tasks;

import jakarta.validation.constraints.NotBlank;
import siem.todolist.models.Color;
import siem.todolist.models.Status;
import siem.todolist.models.Task;

public record TaskCreateDTO(
        @NotBlank(message = "Task is required")
        String task
) {

    public Task toEntity() {
        Task task = new Task();
        task.setTask(this.task);
        task.setStatus(Status.PENDING);
        task.setColor(Color.NONE);
        return task;
    }
}
