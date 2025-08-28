public class Parser {

    public static String getType(String command) {
        return command.split(" ")[0];
    }

    public static String getDescription(String command) {
        return command.split("/")[0].substring(command.split("/")[0].indexOf(' ') + 1).trim();
    }

    public static int getIndex(String command) {
        return Integer.parseInt(command.split(" ")[1]) - 1;
    }
}
