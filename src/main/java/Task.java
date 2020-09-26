/**
 * A class for task objects in Duke.
 * It is the parent class of todo, deadline and event classes.
 */

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates new Task given the description.
     * @param description Description of task.
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public void taskDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] "); //return tick or X symbols
    }

    public String writeToFile() {
        return "write to file";
    }

    public String toString() {
        return this.getStatusIcon() + this.getDescription();
    }

}
