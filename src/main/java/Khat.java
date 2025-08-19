import java.util.Scanner;

public class Khat {
    public static void main(String[] args) {

        String command;
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Hello! I'm Khat.\nWhat can I do for you?\n");
        command = userInputScanner.nextLine();
        while (!command.equals("bye")) {
            System.out.println(command);
            command = userInputScanner.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
