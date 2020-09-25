public class Event extends Task {

    protected String at;
    protected String formattedAt;

    public Event(String description, String at) {
        super(description);
        formattedAt = Parser.getFormattedDate(at.strip());
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + formattedAt + ")";
    }

    @Override
    public String writeToFile() {
        return "E|" + isDone + "|" + this.description + "|" + formattedAt + "\n";
    }
}
