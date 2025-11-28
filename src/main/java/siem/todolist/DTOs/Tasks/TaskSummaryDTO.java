package siem.todolist.DTOs.Tasks;

import siem.todolist.models.Color;
import siem.todolist.models.Status;
import siem.todolist.models.Task;

public record TaskSummaryDTO (
        Long id,
        String task,
        String body,
        Status status,
        Color color
){
    public static TaskSummaryDTO fromEntity(Task task){
        return new TaskSummaryDTO(
                task.getId(),
                task.getTask(),
                task.getBody(),
                task.getStatus(),
                task.getColor()
        );
    }
}
