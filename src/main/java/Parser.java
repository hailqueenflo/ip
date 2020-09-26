import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DELETE = "delete";
    public static final String DONE = "done";
    public static final String FIND = "find";
    public static final String BYE = "bye";
    public static final String LIST = "list";
    public static final String ERROR = "error";

    /**
     * Makes sense of user input and figures out command.
     * Incorrect input is dealt with.
     * @param userInput User input command line.
     * @return appropriate command
     * @throws DukeException Throw invalid exceptions.
     */
    public static String getCommand(String userInput) {
        try {
            if(userInput.equals(LIST)) {
                return LIST;
            } else if(userInput.equals(BYE)) {
                return BYE;
            } else if(userInput.equals(TODO) || userInput.equals(DEADLINE)
                    || userInput.equals(EVENT) || userInput.equals(DELETE) || userInput.equals(DONE)) {
                throw new DukeException();
            } else if(userInput.contains(TODO)) {
                return TODO;
            } else if(userInput.contains(DEADLINE)) {
                return DEADLINE;
            } else if(userInput.contains(EVENT)) {
                return EVENT;
            } else if(userInput.contains(DELETE)) {
                return DELETE;
            } else if (userInput.contains(DONE)) {
                return DONE;
            } else if (userInput.contains(FIND)) {
                return FIND;
            } else {
                throw new DukeException();
            }
        } catch (DukeException e) {
            Ui.printExceptionMessage(userInput);
            return ERROR;
        }
    }

    /**
     * Makes sense of date for Deadline and Event tasks.
     * @param dateAndTime User input date/time.
     * @return Formatted date.
     */
    public static String getFormattedDate(String dateAndTime) {
        LocalDate date;
        String formattedDate;
        try {
            date = LocalDate.parse(dateAndTime);
            formattedDate = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        } catch (Exception e) {
            formattedDate = dateAndTime;
        }
        return formattedDate;
    }

}
