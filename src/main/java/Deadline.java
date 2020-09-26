public class Deadline extends Task {

    protected String by;
    protected String formattedBy;

    public Deadline(String description, String by) {
        super(description);
        formattedBy = Parser.getFormattedDate(by.strip());
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formattedBy + ")";
    }

    @Override
    public String writeToFile() {
        return "D|" + isDone + "|" + this.description + "|" + formattedBy + "\n";
    }
}
