/**
 * Child class of Task.
 * Deadline tasks are added given description and date of task.
 */

public class Deadline extends Task {

    protected String by;
    protected String formattedBy;

    /**
     * Constructs new Deadline task given description and due date.
     * @param description Description of Deadline task.
     * @param by Due date of Deadline task.
     */
    public Deadline(String description, String by) {
        super(description);
        formattedBy = Parser.getFormattedDate(by.strip());
        this.by = by;
    }

    /**
     * Converts Deadline task into a formatted string.
     * @return formatted string.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formattedBy + ")";
    }

    @Override
    public String writeToFile() {
        return "D|" + isDone + "|" + this.description + "|" + formattedBy + "\n";
    }
}
