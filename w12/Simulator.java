import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Simulator {
    private static final int DEFAULT_HEIGHT = 50;
    private static final int DEFAULT_WIDTH = 50;
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;

    private Field field;
    private SimulatorView view;
    private List<Animal> animals;
    private int step;

    public Simulator() {
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    public Simulator(int height, int width) {
        field = new Field(height, width);
        view = new SimulatorView(height, width);
        animals = new ArrayList<>();

        view.setColor(Rabbit.class, "white");
        view.setColor(Fox.class, "orange");

        reset();
    }

    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
        }
    }

    public void simulateOneStep() {
        step++;
        List<Animal> newAnimals = new ArrayList<>();

        Iterator<Animal> it = animals.iterator();
        while (it.hasNext()) {
            Animal animal = it.next();
            if (animal.isAlive()) {
                animal.act(newAnimals);
            } else {
                it.remove();
            }
        }

        animals.addAll(newAnimals);

        view.showStatus(step, field);
    }

    public void reset() {
        step = 0;
        animals.clear();
        field.clear();
        populate();
        view.showStatus(step, field);
    }

    private void populate() {
        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if (Randomizer.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(field, location);
                    animals.add(fox);
                } else if (Randomizer.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(field, location);
                    animals.add(rabbit);
                }
            }
        }
    }

    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.simulate(200);
    }
}