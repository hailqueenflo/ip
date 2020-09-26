import java.io.IOException;

/**
 * Main class of Duke, a personal task-tracking assistant.
 * Duke is able to keep track of todos, events and deadlines.
 */

public class Duke {

    private static Storage storage;
    private static TaskList tasks;
    private static Ui ui;
    private static final String FILE_PATH = "duke.txt";
    public static int counter = 0;

    /**
     * Initialises Duke.
     * @param filePath File path of text file where information is saved to.
     * @throws IOException Error encountered when accessing file.
     */

    public Duke(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
    }

    /**
     * Starts Duke.
     * @throws DukeException Error occurs.
     */

    public void run() throws DukeException {
        counter = storage.retrieveFromFile(tasks);
        ui.printHelloMessage();
        ui.getCount(counter);
        ui.commands(tasks);
        ui.printByeMessage();
        storage.writeToFile(tasks);
    }

    /**
     * Initialises and starts Duke.
     * @param args Contains command arguments.
     * @throws DukeException Error occurs.
     * @throws IOException Error encountered when accessing file.
     */

    public static void main(String[] args) throws DukeException, IOException {
        new Duke(FILE_PATH).run();
    }
}