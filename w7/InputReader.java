import java.util.Scanner;

public class InputReader {
    private final Scanner reader;

    public InputReader() {
        reader = new Scanner(System.in);
    }

    /** Mengembalikan satu baris input (lowercase & trimmed) */
    public String getInputLine() {
        System.out.print("> ");
        return reader.nextLine().trim().toLowerCase();
    }
}
