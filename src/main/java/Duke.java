import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String horLine = "    ____________________________________________________________";
        String hello = horLine +
                "\n     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                horLine;
        String goodbye = horLine +
                "\n     Bye. Hope to see you again soon!\n" + horLine;

        TaskType list = new TaskType();
        FileAccess fileAccess = new FileAccess(list);
        fileAccess.writeToFile();

        // print hello message
        System.out.println(hello);

        TaskType taskType = new TaskType();
        String line;
        Scanner in = new Scanner(System.in);

        do {
            line = in.nextLine();   // user input
            execute(line, taskType);
        } while (!(line.equals("bye")));

        System.out.println(goodbye);
    }

    private static void printHorLine() {
        System.out.println("    ____________________________________________________________");
    }

    private static void execute(String line, TaskType taskType) {

        int spacePosition = line.indexOf(" ");  // position of first space
        // identify command using position of space
        String command = spacePosition > 0 ? line.substring(0, spacePosition) : line;
        String num;

        switch (command) {
        case "list":
            printList(taskType);
            break;
        case "done":
            num = line.substring(spacePosition + 1);
            printDone(taskType, num);
            break;
        case "bye":
            break;
        case "todo":
        case "deadline":
        case "event":
            addTask(taskType, command, line);
            break;
        case "delete":
            num = line.substring(spacePosition + 1);
            deleteTask(taskType, num);
            break;
        default:
            printInvalidMeaning();
            break;
        }
    }

    private static void printList(TaskType taskType) {
        printHorLine();
        System.out.println("      Here are the tasks in your list:");
        taskType.listTasks();
        printHorLine();
    }

    private static void printDone(TaskType taskType, String num) {
        int id = Integer.parseInt(num);
        Task task = taskType.markAsDone(id);
        printHorLine();
        System.out.println("     Nice! I've marked this task as done: \n" + "       " +
                task.toString());
        printHorLine();
    }

    private static void printCannotBeEmpty(String command) {
        printHorLine();
        System.out.println("     ☹ OOPS!!! The description of a " + command + " cannot be empty.");
        printHorLine();
    }

    private static void printInvalidMeaning() {
        printHorLine();
        System.out.println("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        printHorLine();
    }

    private static void addTask(TaskType taskType, String command, String line) {
        int spacePosition = line.indexOf(" ");
        int byPosition;
        int atPosition;
        String description;

        // check for blank description
        try {
            description = line.substring(spacePosition).strip();
        } catch (StringIndexOutOfBoundsException e) {
            printCannotBeEmpty(command);
            return;
        }

        String by, at;
        Task task;

        switch (command) {
        case "todo":
            task = taskType.addTodo(description);
            break;
        case "deadline":
            byPosition = description.indexOf("/by");
            by = description.substring(byPosition + 4);
            description = description.substring(0, byPosition - 1);
            task = taskType.addDeadline(description, by);
            break;
        case "event":
            atPosition = description.indexOf("/at");
            at = description.substring(atPosition + 4);
            description = description.substring(0, atPosition - 1);
            task = taskType.addEvent(description, at);
            break;
        default:
            printInvalidMeaning();
            return;
        }
        printHorLine();

        if (task != null) {
            System.out.println("     Got it. I've added this task: \n" + "       " +
                    task.toString() + "\n     Now you have " +
                    TaskType.getTasksCount() + " tasks in the list.");
            printHorLine();
        }
    }

    private static void deleteTask(TaskType taskType, String num) {
        int id = Integer.parseInt(num);
        Task task = taskType.deleteTask(id);
        printHorLine();
        System.out.println("     Noted. I've removed this task: \n" + "       " +
                task.toString() + "\n     Now you have " +
                TaskType.getTasksCount() + " tasks in the list.");
        printHorLine();
    }
}
