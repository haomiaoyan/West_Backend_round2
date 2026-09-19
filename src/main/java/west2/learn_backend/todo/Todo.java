package west2.learn_backend.todo;

import java.time.Instant;

public class Todo {
    private  String id;
    private String title;
    private String content;
    private Boolean completed;
    private Instant createdAt;
    private Instant updatedAt;

    public Todo() {
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Todo(String id, String title, String content,
                Boolean completed, Instant created,
                Instant updateAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.completed = completed;
        this.createdAt = created;
        this.updatedAt = updateAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
