/**
 * Child class of Task.
 * Todo tasks are added given description of task.
 */

public class Todo extends Task {

    /**
     * Constructs new Todo task given description.
     * @param description Description of Todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts Todo task into a formatted string.
     * @return formatted string.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String writeToFile() {
        return "T|" + isDone + "|" + this.description + "\n";
    }
}