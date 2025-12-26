public class Command {
    private String author;
    private String text;
    private int rating;

    public Command(String author, String text, int rating) {
        this.author = author;
        this.text = text;
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return author + " (" + rating + "/5): " + text;
    }
}