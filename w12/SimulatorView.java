public class SimulatorView {
    private FieldStats stats;
    private int width, height;

    public SimulatorView(int height, int width) {
        this.height = height;
        this.width = width;
        this.stats = new FieldStats();
    }

    public void setColor(Class cl, String color) {
    }

    public boolean isViable(Field field) {
        return true;
    }

    public void showStatus(int step, Field field) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Simulasi Langkah: " + step);
        System.out.println("============================");

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Animal animal = field.getObjectAt(row, col);
                if (animal instanceof Fox) {
                    System.out.print(" F ");
                } else if (animal instanceof Rabbit) {
                    System.out.print(" R ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println("============================");

        stats.generateCounts(field);
        System.out.println(stats.getStats());

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
        }
    }
}