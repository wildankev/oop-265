public class FieldStats {
    private Counter foxCounter;
    private Counter rabbitCounter;
    private boolean countsValid;

    public FieldStats() {
        foxCounter = new Counter("Foxes");
        rabbitCounter = new Counter("Rabbits");
        countsValid = true;
    }

    public void generateCounts(Field field) {
        foxCounter.reset();
        rabbitCounter.reset();
        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Animal animal = field.getObjectAt(row, col);
                if (animal != null) {
                    if (animal instanceof Fox) {
                        foxCounter.increment();
                    } else if (animal instanceof Rabbit) {
                        rabbitCounter.increment();
                    }
                }
            }
        }
        countsValid = true;
    }

    public String getStats() {
        if (!countsValid) {
            return "";
        }
        return foxCounter.getName() + ": " + foxCounter.getCount() + "   " +
                rabbitCounter.getName() + ": " + rabbitCounter.getCount();
    }

    public void invalidateCounts() {
        countsValid = false;
    }
}