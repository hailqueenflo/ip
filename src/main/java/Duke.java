import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Duke {
    public static final int MAX_SIZE = 100;
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DELETE = "delete";
    public static final String DONE = "done";
    public static final String BYE = "bye";
    public static final String LIST = "list";
    public static final String FILE_PATH = "duke.txt";
    public static ArrayList<Task> tasks = new ArrayList<>();

    // write to the file
    public static void writeToFile(String FILE_PATH) {
        try {
            File f = new File(FILE_PATH);
            FileWriter fw = new FileWriter(FILE_PATH);
            for (Task task : tasks) {
                fw.write(task.writeToFile());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
    }

    // retrieve from the file
    public static void retrieveFromFile(String FILE_PATH) {
        try {
            File file = new File(FILE_PATH);
            Scanner s = new Scanner(file);
            Task task;
            while (s.hasNext()) {
                String[] parseTask = s.nextLine().split("\\|");
                switch (parseTask[0]) {
                case "T":
                    task = new Todo(parseTask[2]);
                    break;
                case "D":
                    task = new Deadline(parseTask[2], parseTask[3]);
                    break;
                case "E":
                    task = new Event(parseTask[2], parseTask[3]);
                default:
                    task = new Task(parseTask[2]);
                }
                if(parseTask[1].equals("true")) {
                    task.markAsDone(true);
                }
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("This file is not found!");
        }
    }

    public static void printHorLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printHelloMessage() {
        printHorLine();
        System.out.println("     Hello! I'm Duke\n" + "     What can I do for you?");
        printHorLine();
    }

    public static void printByeMessage() {
        printHorLine();
        System.out.println("     Bye. Hope to see you again soon!");
        printHorLine();
    }

    public static void printTaskAddition(Task task, int index) {
        printHorLine();
        System.out.println("     Got it. I've added this task: \n" + "       " +
                task.toString() + "\n     Now you have " +
                index + " tasks in the list.");
        printHorLine();
    }

    public static void printList(ArrayList<Task> tasks) {
        printHorLine();
        int index = 0;
        for (Task task : tasks) {
            System.out.println("     " + (index + 1) + "." +
                    "     " + task.toString());
            index++;
        }
        printHorLine();
    }

    public static void printCannotBeEmpty(String[] command) {
        printHorLine();
        System.out.println("     ☹ OOPS!!! The description of a " + Arrays.toString(command) + " cannot be empty.");
        printHorLine();
    }

    public static void printInvalidMeaning() {
        printHorLine();
        System.out.println("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    // mark task as done
    public static void markAsDone(Task task) {
        printHorLine();
        task.markAsDone(true);
        System.out.println("     Nice! I've marked this task as done: \n" + "       " +
                task.toString());
        printHorLine();
    }

    public static Task createTypes (String input) {
        String[] taskType = input.split(" ");
        int taskTypeLength;
        try {
            switch (taskType[0]) {
            case TODO:
                taskTypeLength = 4;
                if (taskType.length == 1) {
                    throw new DukeException();
                }
                return new Todo(input.substring(taskTypeLength + 1));
            case DEADLINE:
                taskTypeLength = 8;
                if(taskType.length == 1 || !input.contains("/by")) {
                    throw new DukeException();
                }
                int indexOfBy = input.indexOf("/");
                return new Deadline(input.substring(taskTypeLength + 1, indexOfBy - 1),
                        input.substring(indexOfBy + 4));
            case EVENT:
                taskTypeLength = 5;
                if(taskType.length == 1 || !input.contains("/at")) {
                    throw new DukeException();
                }
                int indexOfAt = input.indexOf("/");
                return new Event(input.substring(taskTypeLength + 1, indexOfAt - 1),
                        input.substring(indexOfAt + 4));
            default:
                printInvalidMeaning();
                return null;
            }
        } catch (DukeException e) {
            printCannotBeEmpty(taskType);
            return null;
        }
    }

    public static void deleteTask(ArrayList<Task> tasks, int index) {
        printHorLine();
        System.out.println("     Noted. I've removed this task: \n" + "       " +
                tasks.get(index).toString());
        tasks.remove(tasks.get(index));
        System.out.println("\n     Now you have " +
                tasks.size() + " tasks in the list.");
        printHorLine();
    }

    public static void main(String[] args) {

        retrieveFromFile(FILE_PATH);
        Scanner in = new Scanner(System.in);

        printHelloMessage();

        String userInput = in.nextLine();
        while (!userInput.equals(BYE)) {
            if (userInput.equals(LIST)) {
                printList(tasks);
            } else if (userInput.startsWith(DONE)) {
                try {
                    int indexOfNumber = 5;
                    int indexOfTask = Integer.parseInt(userInput.substring(indexOfNumber)) - 1;
                    markAsDone(tasks.get(indexOfTask));
                    writeToFile(FILE_PATH);
                } catch (NumberFormatException e) {
                    printHorLine();
                    System.out.println("     ☹ OOPS!!! Please input the number of the task you've completed.");
                    printHorLine();
                }
            } else if (userInput.startsWith(DELETE)) {
                try {
                    int indexOfNumber = 7;
                    int indexOfTask = Integer.parseInt(userInput.substring(indexOfNumber)) - 1;
                    if (indexOfTask > tasks.size()) {
                        throw new DukeException();
                    }
                    deleteTask(tasks, indexOfTask);
                    writeToFile(FILE_PATH);
                } catch (DukeException e) {
                    printHorLine();
                    System.out.println("     ☹ OOPS!!! This task does not exist.");
                    printHorLine();
                }
            } else {
                Task newTask = createTypes(userInput);
                if (newTask != null) {
                    tasks.add(newTask);
                    printTaskAddition(newTask, tasks.size());
                    writeToFile(FILE_PATH);
                }
            }
            userInput = in.nextLine();
        }
        printByeMessage();
    }
}
