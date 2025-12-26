import java.util.ArrayList;

public class SalesItem {
    private String name;
    private int price;
    private ArrayList<Command> Commands;

    public SalesItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.Commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /**
     * Menambahkan komentar baru.
     * - Return false jika rating tidak valid (bukan 1-5)
     * - Return false jika author sudah pernah berkomentar
     * - Return true jika berhasil ditambahkan
     */
    public boolean addCommand(String author, String text, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }

        for (Command existing : Commands) {
            if (existing.getAuthor().equalsIgnoreCase(author)) {
                return false;
            }
        }

        Command newCommand = new Command(author, text, rating);
        Commands.add(newCommand);
        return true;
    }

    public ArrayList<Command> getCommands() {
        return Commands;
    }
}