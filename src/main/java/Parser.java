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
}
