public class Task {
    protected String description;
    protected boolean isDone;
    protected int id;
    protected static int num = 0;

    public Task(String description) {
        this.description = description;
        num++;
        id = num;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public static int getNum() {
        return num;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] "); //return tick or X symbols
    }
}