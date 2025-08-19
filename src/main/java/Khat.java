import java.util.Scanner;

public class Khat {
    public static void main(String[] args) {

        String command;
        int commandCounter = 0;
        String[] commandList = new String[100];
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Hello! I'm Khat.\nWhat can I do for you?");
        command = userInputScanner.nextLine();
        while (!command.equals("bye")) {
            if (command.equals("list")) {
                for (int i = 0; i < commandCounter; i++) {
                    String currCommand = commandList[i];
                    System.out.println(i + 1 + ". " + currCommand);
                }
                command = userInputScanner.nextLine();
            } else {
                System.out.println("added: " + command);
                commandList[commandCounter] = command;
                commandCounter++;
                command = userInputScanner.nextLine();
            }

        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
