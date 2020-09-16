public class Task {
    protected String description;
    protected boolean isDone;
    protected int id;
    private static int numOfTasks = 0;

    public Task(String description) {
        this.description = description;
        numOfTasks++;
        id = numOfTasks;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return "type";
    }

    public String getTime() {
        return "by/at";
    }

    public int getId() {
        return id;
    }

    public static int getNumOfTasks() {
        return numOfTasks;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] "); //return tick or X symbols
    }

    public String toString() {
        return this.getStatusIcon() + this.getDescription();
    }
}
