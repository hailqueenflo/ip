import java.util.ArrayList;

public class TaskType {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private static int tasksCount = 0;

    public static int getTasksCount() {
        return tasksCount;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        tasksCount++;
        return task;
    }

    public Task deleteTask(int id) {
        Task task = tasks.get(id - 1);
        tasks.remove(id - 1);
        tasksCount--;
        return task;
    }

    public Task addTodo(String description) {
        Todo todo = new Todo(description);
        return this.addTask(todo);
    }

    public Task addDeadline(String description, String by) {
        Deadline deadline = new Deadline(description, by);
        return this.addTask(deadline);
    }

    public Task addEvent(String description, String at) {
        Event event = new Event(description, at);
        return this.addTask(event);
    }

    public Task markAsDone(int id) {
        Task task = tasks.get(id - 1);
        task.markAsDone();
        return task;
    }

    public void listTasks() {
        for (int i = 0; i < tasksCount; i++) {
            System.out.println("     " + (i + 1) + "." + "     " + tasks.get(i).toString());
        }
    }
}
