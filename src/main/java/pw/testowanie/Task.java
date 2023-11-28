package pw.testowanie;

public class Task {
    private static long taskIdCounter = 1;
    private final long id;
    private String name;
    private String details;
    private String user;
    private Priority priority;
    private Status status;

    public Task(String name,
                String details,
                String user,
                Priority priority) {
        this.id = taskIdCounter++;
        this.name = name;
        this.details = details;
        this.user = user;
        this.priority = priority;
        this.status = Status.IN_PROGRESS;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}