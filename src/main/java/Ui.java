import java.util.Scanner;

public class Ui {

    private Scanner scanner = new Scanner(System.in);
    private static final String DIVIDER = "______________________________";

    public void showWelcome() {
        System.out.println("Hello! I'm Khat.\nWhat can I do for you?");
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showDivider() {
        System.out.println(DIVIDER);
    }

    public void showError(String message) {
        System.out.println(message);
    }

}
