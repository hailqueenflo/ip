public class Task {
    protected String description;
    protected boolean isDone;

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

    public String getBooleanStatus() {
        return (isDone ? "1" : "0");
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] "); //return tick or X symbols
    }

    public String writeToFile() {
        return "T|" + this.getBooleanStatus() + "|" + this.description + "\n";
    }

    @Override
    public String toString() {
        return this.getStatusIcon() + this.getDescription();
    }
}
