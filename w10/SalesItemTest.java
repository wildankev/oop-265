import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalesItemTest {
    public SalesItemTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddCommand() {
        SalesItem item = new SalesItem("Item1", 10999);
        assertEquals(true, item.addCommand("Hendrata", "So great and delicious", 5));
    }

    @Test
    public void testIllegalRating() {
        SalesItem item = new SalesItem("Item1", 10999);
        assertEquals(false, item.addCommand("Illegal", "This is the worst item in the world", 0));
    }

    @Test
    public void testDuplicateAuthor() {
        SalesItem item = new SalesItem("Item1", 10999);
        assertEquals(true, item.addCommand("Hendrata", "So great and delicious", 5));
        assertEquals(false, item.addCommand("Hendrata", "Not bad", 3));
    }
}