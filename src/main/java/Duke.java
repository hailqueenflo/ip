import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        String line = in.nextLine();
        // when input is not "bye"
        while (!(line.equals("bye"))) {
            System.out.println("____________________________________________________________");
            System.out.println(line);
            System.out.println("____________________________________________________________");
            line = in.nextLine();
        }

        // when input is "bye"
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
