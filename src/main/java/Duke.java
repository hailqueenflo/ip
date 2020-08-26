import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "null";
        String[] commandList = new String[100];
        int num = 0;

        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");

        // when input is not "bye"
        while (!(line.equals("bye"))) {
            line = in.nextLine();

            // when input is "bye"
            if(line.equals("bye")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
            }

            else if(line.equals("list")) {
                System.out.println("    ____________________________________________________________");
                for (int i = 0; i < num; i++) {
                    System.out.println("     " + (i + 1) + ". " + commandList[i]);
                }
                System.out.println("    ____________________________________________________________");
            }
            else {
                commandList[num] = line;
                System.out.println("    ____________________________________________________________");
                System.out.println("     " + "added: " + line);
                System.out.println("    ____________________________________________________________");
                num++;
            }
        }
    }
}
