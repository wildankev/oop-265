public class CommandWords {
    private static final String[] validCommands = { "go", "help", "look", "quit" };

    public boolean isCommand(String aString) {
        for (String command : validCommands) {
            if (command.equals(aString)) {
                return true;
            }
        }
        return false;
    }

    public String showAll() {
        StringBuilder sb = new StringBuilder();
        for (String command : validCommands) {
            sb.append(command).append(" ");
        }
        return sb.toString();
    }
}