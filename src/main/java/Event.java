/**
 * Child class of Task.
 * Event tasks are added given description and date of task.
 */

public class Event extends Task {

    protected String at;
    protected String formattedAt;

    /**
     * Constructs new Event task given description and date.
     * @param description Description of Event task.
     * @param at Date of Event task.
     */
    public Event(String description, String at) {
        super(description);
        formattedAt = Parser.getFormattedDate(at.strip());
        this.at = at;
    }

    /**
     * Converts Event task into a formatted string.
     * @return formatted string.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + formattedAt + ")";
    }

    @Override
    public String writeToFile() {
        return "E|" + isDone + "|" + this.description + "|" + formattedAt + "\n";
    }
}
