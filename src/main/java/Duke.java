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

        Scanner in = new Scanner(System.in);
        String line = "null";
        Task[] taskList = new Task[100];

        // print hello message
        System.out.println(hello);

        line = in.nextLine();

        // when input is not "bye"
        while (!(line.equals("bye"))) {
            String[] words = line.split(" ");

            if(line.equals("list")) {
                System.out.println(horLine + "\n Here are the tasks in your list:");
                for (int i = 0; i <Task.getNum(); i++) {
                    System.out.println("     " + (i + 1) + ". " +
                            taskList[i].getStatusIcon() +
                            taskList[i].getDescription());
                }
                System.out.println(horLine);
            }
            else if(words[0].equals("done")) {
                int id = Integer.parseInt(words[1]);
                Task task = taskList[id-1];
                task.markAsDone();
                System.out.println(horLine +
                        "\n     Nice! I've marked this task as done: \n" + "       " +
                        task.getStatusIcon() + " " + task.getDescription() + "\n" + horLine);
            }
            else {
                Task newTask = new Task(line);
                taskList[newTask.getId()-1] = newTask;
                System.out.println(horLine +
                        "\n     added: " + line + '\n' + horLine);
            }
            line = in.nextLine();
        }
        System.out.println(goodbye);
    }
}
