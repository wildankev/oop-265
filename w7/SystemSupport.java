public class SystemSupport {
    private final InputReader reader;
    private final Responder responder;

    public SystemSupport() {
        reader = new InputReader();
        responder = new Responder();
    }

    public void start() {
        boolean finished = false;
        printWelcome();

        while (!finished) {
            String input = reader.getInputLine();

            if (input.equals("bye") || input.equals("quit") || input.equals("exit")) {
                finished = true;
            } else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    private void printWelcome() {
        System.out.println("=== Selamat datang di MyITS Technical Support ===");
        System.out.println();
        System.out.println("Silakan jelaskan masalah Anda. Kami akan membantu kendala perkuliahan/FRS/KRS.");
        System.out.println("Ketik 'bye' atau 'quit' untuk keluar.");
        System.out.println("------------------------------------------------------------");
    }

    private void printGoodbye() {
        System.out.println("Terima kasih telah menggunakan layanan ini.");
    }

    public static void main(String[] args) {
        new SystemSupport().start();
    }
}