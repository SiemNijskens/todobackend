package siem.todolist.models;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String task;

    private String body;

    private String quote;

    @Enumerated(value= EnumType.ORDINAL)
    private Status status;

    @Enumerated(value= EnumType.ORDINAL)
    private Color color;

    public Task(Long id, String task, String body, Status status, Color color, String quote) {
        this.id = id;
        this.task = task;
        this.body = body;
        this.status = status;
        this.color = color;
        this.quote = quote;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public String getQuote() {
        return Quote;
    }

    public void setQuote(String quote) {
        Quote = quote;
    }
}

