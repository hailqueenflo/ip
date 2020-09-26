import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Loads and saves tasks to file.
 */

public class Storage {

    public static ArrayList<Task> tasksArrayList;
    private static File f;
    private static String filePath;
    public static int fileTasksCounter = 0;

    /**
     * Constructs storage.
     * Initialises file and file path.
     * @param filePath Destination of file.
     * @throws IOException Error in accessing file.
     */
    public Storage(String filePath) throws IOException {
        f = new File(filePath);
        this.filePath = filePath;
    }

    /**
     * Saves tasks to file.
     * @param tasks The taskList that contains list of tasks.
     */
    public static void writeToFile(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(filePath);
            tasksArrayList = tasks.getTasksList();
            for (Task task : tasksArrayList) {
                fw.write(task.writeToFile());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
    }

    /**
     * Reads from file.
     * @param tasks The taskList that contains list of tasks.
     */
    public static int retrieveFromFile(TaskList tasks) {
        try {
            Scanner s = new Scanner(f);
            Task task;
            while (s.hasNext()) {
                String[] parseTask = s.nextLine().split("\\|");
                String taskType = parseTask[0];
                String taskIsDone = parseTask[1];
                String taskDescription = parseTask[2];
                // detect what type of task it is
                switch (taskType) {
                case "T":
                    task = new Todo(taskDescription);
                    fileTasksCounter++;
                    break;
                case "D":
                    String taskBy = parseTask[3];
                    task = new Deadline(taskDescription, taskBy);
                    fileTasksCounter++;
                    break;
                case "E":
                    String taskAt = parseTask[3];
                    task = new Event(taskDescription, taskAt);
                    fileTasksCounter++;
                    break;
                default:
                    task = new Task(taskDescription);
                    break;
                }
                if(taskIsDone.equals("true")) {
                    task.markAsDone(true);
                }
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("This file is not found, creating a new file now!");
        }
        return fileTasksCounter;
    }
}
