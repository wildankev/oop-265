import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");

        String inputLine = reader.nextLine();
        String word1 = null;
        String word2 = null;

        Scanner tok = new Scanner(inputLine);
        if (tok.hasNext()) {
            word1 = tok.next();
            if (tok.hasNext()) {
                word2 = tok.next();
            }
        }

        if (commands.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }
}