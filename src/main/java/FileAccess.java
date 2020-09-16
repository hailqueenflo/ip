import java.io.FileWriter;
import java.io.IOException;

public class FileAccess {
    private static final String FILE_PATH = "./docs/duke.txt";

    private final TaskType taskType;

    public FileAccess (TaskType list) {
        this.taskType = list;
    }
    public void writeToFile () {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);

            for (Task task : taskType.getTasks()) {
                fw.write(task.getType() + " | " +
                        task.getStatusIcon() + " | " +
                        task.getDescription() + " | " +
                        task.getTime() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }
}
