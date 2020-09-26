import java.util.Scanner;

/**
 * Class that deals with user interface.
 * Contains messages to be printed.
 */
public class Ui {

    public static int tasksCounter = 0;
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DELETE = "delete";
    public static final String DONE = "done";
    public static final String BYE = "bye";
    public static final String LIST = "list";
    public Parser parser;

    /**
     * Finds number of tasks in list.
     * @param counter Total number of tasks in taskList.
     */
    public void getCount(int counter) {
        this.tasksCounter = counter;
    }

    public static void printHorLine() {
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Standard method to print, with horizontal lines wrapping message.
     * @param content Message to be printed.
     */
    public static void printMessage(String content) {
        printHorLine();
        System.out.println(content);
        printHorLine();
    }

    /**
     * Greets user when Duke starts.
     */
    public static void printHelloMessage() {
        printMessage("     Hello! I'm Duke\n" + "     What can I do for you?");
    }

    /**
     * Says bye to user when exit is requested.
     */
    public static void printByeMessage() {
        printMessage("     Bye. Hope to see you again soon!");
    }

    /**
     * Prints confirmation that task has been added.
     * @param task The taskList that contains all commands for tasks.
     */
    public static void printTaskAddition(Task task) {
        if(tasksCounter == 1) {
            printMessage("     Got it. I've added this task: \n" + "       " +
                    task + "\n     Now you have " +
                    tasksCounter + " task in the list.");
        } else {
            printMessage("     Got it. I've added this task: \n" + "       " +
                    task + "\n     Now you have " +
                    tasksCounter + " tasks in the list.");
        }
    }

    /**
     * Prints error message when description is empty,
     * or task to be marked as done/deleted does not exist.
     * @param userInput User input command line.
     */
    public static void printExceptionMessage(String userInput) {
        if(userInput.equals(TODO) || userInput.equals(EVENT) || userInput.equals(DEADLINE)) {
            String invalidInputType = null;
            switch (userInput) {
            case TODO:
                invalidInputType = TODO;
                break;
            case DEADLINE:
                invalidInputType = DEADLINE;
                break;
            case EVENT:
                invalidInputType = EVENT;
                break;
            }
            printMessage("     ☹ OOPS!!! The timing or description of a " + invalidInputType + " cannot be empty.");
        } else if(userInput.contains(DONE)) {
            if(tasksCounter == 1) {
                printMessage("     ☹ OOPS!!! This task cannot be marked as done as it does not exist.\n" +
                        "     You have " + tasksCounter + " task in the list.");
            } else {
                printMessage("     ☹ OOPS!!! This task cannot be marked as done as it does not exist.\n" +
                        "     You have " + tasksCounter + " tasks in the list.");
            }
        } else if(userInput.contains(DELETE)) {
            if(tasksCounter == 1) {
                printMessage("     ☹ OOPS!!! This task cannot be deleted as it does not exist.\n" +
                        "     You have " + tasksCounter + " task in the list.");
            } else {
                printMessage("     ☹ OOPS!!! This task cannot be deleted as it does not exist.\n" +
                        "     You have " + tasksCounter + " tasks in the list.");
            }
        } else {
            printMessage("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    /**
     * Handles user input command line.
     * @param tasks The taskList that contains all commands for tasks.
     * @throws DukeException Exception thrown when user input command is invalid.
     */
    public void commands(TaskList tasks) throws DukeException {
        Scanner in = new Scanner(System.in);
        String userInput;

        while(in.hasNextLine()) {
            userInput = in.nextLine();
            String command = parser.getCommand(userInput);
            switch(command) {
            case TODO:
                tasks.addTodo(userInput);
                break;
            case DEADLINE:
                tasks.addDeadline(userInput);
                break;
            case EVENT:
                tasks.addEvent(userInput);
                break;
            case DELETE:
                tasks.deleteItem(userInput, tasksCounter);
                break;
            case DONE:
                tasks.markAsDone(userInput, tasksCounter);
                break;
            case LIST:
                tasks.printTaskList();
                break;
            case BYE:
                return;
            }
        }
    }
}