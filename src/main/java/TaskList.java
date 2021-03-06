import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Stores all task information into an array list.
 */

public class TaskList {

    public static ArrayList<Task> tasksList;

    public TaskList() {
        this.tasksList = new ArrayList<>();
    }

    public void add(Task task) {
        tasksList.add(task);
    }

    /**
     * Gets task list.
     * @return The task list.
     */
    public ArrayList<Task> getTasksList() {
        return tasksList;
    }

    /**
     * Prints task list.
     */
    public static void printTaskList() {
        int taskIndex = 1;
        Ui.printHorLine();
        for(Task task : tasksList) {
            System.out.println(taskIndex + ". " + task);
            taskIndex++;
        }
        Ui.printHorLine();
    }

    /**
     * Adds Todo task to taskList.
     * @param input User input description of task.
     */
    public static void addTodo(String input) {
        int taskTypeLength = 4;
        String todoDescription = input.substring(taskTypeLength + 1);
        Task task = new Todo(todoDescription);
        tasksList.add(task);
        Ui.tasksCounter++;
        Ui.printTaskAddition(task);
    }

    /**
     * Adds Deadline task to taskList.
     * @param input User input description and deadline of task.
     */
    public static void addDeadline(String input) {
        int taskTypeLength = 8;
        int indexOfBy = input.indexOf("/");
        int byLength = 4;   // length of "/by:"
        String deadlineDescription = input.substring(taskTypeLength + 1, indexOfBy - 1);
        String deadlineBy = input.substring(indexOfBy + byLength);
        Task task = new Deadline(deadlineDescription, deadlineBy);
        tasksList.add(task);
        Ui.tasksCounter++;
        Ui.printTaskAddition(task);
    }

    /**
     * Adds Event task to taskList.
     * @param input User input description and time of task.
     */
    public static void addEvent(String input) {
        int taskTypeLength = 5;
        int indexOfAt = input.indexOf("/");
        int atLength = 4;   // length of "/at:"
        String eventDescription = input.substring(taskTypeLength + 1, indexOfAt - 1);
        String eventAt = input.substring(indexOfAt + atLength);
        Task task = new Event(eventDescription, eventAt);
        tasksList.add(task);
        Ui.tasksCounter++;
        Ui.printTaskAddition(task);
    }

    /**
     * Deletes task from taskList.
     * @param input User input of index of task to be deleted.
     * @param tasksCount Number of tasks in list.
     */
    public static void deleteItem(String input, int tasksCount) {
        int commandLength = 6;
        int itemToDelete = Integer.parseInt(input.substring(commandLength + 1));
        if(itemToDelete > tasksCount) {
            Ui.printExceptionMessage(Ui.DELETE);
        } else {
            Task task = tasksList.remove(itemToDelete - 1);
            tasksCount--;
            Ui.tasksCounter--;
            if (tasksCount == 1) {
                Ui.printMessage("     Noted. I've removed this task: \n" + "     " + task +
                        "\n     Now you have " + tasksCount + " task in the list.");
            } else {
                Ui.printMessage("     Noted. I've removed this task: \n" + "     " + task +
                        "\n     Now you have " + tasksCount + " tasks in the list.");
            }
        }
    }

    /**
     * Marks task as done.
     * @param input User input of index of task to be marked as done.
     * @param tasksCount Number of tasks in list.
     */
    public static void markAsDone(String input, int tasksCount) {
        int commandLength = 4;
        int itemDone = Integer.parseInt(input.substring(commandLength + 1));
        if(itemDone > tasksCount) {
            Ui.printExceptionMessage(Ui.DONE);
        } else {
            tasksList.get(itemDone - 1).taskDone();
            Ui.printHorLine();
            System.out.println("     Nice! I've marked this task as done: ");
            System.out.println("       " + tasksList.get(itemDone - 1));
            Ui.printHorLine();
        }
    }

    /**
     * Searches and collects tasks with user input search term.
     * @param userInput Search term requested by user.
     */
    public static void findTasks(String userInput) {
        int commandLength = 4;
        int numberOfTasksFound = 0;
        String searchItem = userInput.substring(commandLength + 1);
        ArrayList<Task> tasksFound = (ArrayList<Task>) tasksList.stream()
                .filter((tasks) -> tasks.getDescription().contains(searchItem))
                .collect(Collectors.toList());
        Ui.printHorLine();
        System.out.println("     Here are the matching tasks in your list:");
        for(Task task : tasksFound) {
            numberOfTasksFound++;
            System.out.println("     " + numberOfTasksFound + ". " + task);
        }
        Ui.printHorLine();
        if(numberOfTasksFound == 0) {
            Ui.printHorLine();
            System.out.println("     There are no matching tasks in your list.");
            Ui.printHorLine();
        }
    }
}
