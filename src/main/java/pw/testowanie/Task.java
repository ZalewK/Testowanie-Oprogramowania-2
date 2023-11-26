package pw.testowanie;

public class Task {
    private static long taskIdCounter = 1;

    private final long id;
    private final String name;
    private final String details;

    public Task(String name, String details) {
        this.id = taskIdCounter++;
        this.name = name;
        this.details = details;
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
}
