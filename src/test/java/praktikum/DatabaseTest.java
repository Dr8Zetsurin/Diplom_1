package praktikum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DatabaseTest {

    @Test
    public void testDatabaseInitialization() {
        Database database = new Database();
        
        assertFalse(database.availableBuns().isEmpty());
        assertFalse(database.availableIngredients().isEmpty());
        
        assertEquals(3, database.availableBuns().size());
        assertEquals(6, database.availableIngredients().size());
    }

    @Test
    public void testBunsContent() {
        Database database = new Database();
        
        assertTrue(database.availableBuns().stream()
                .anyMatch(bun -> bun.getName().equals("black bun") && bun.getPrice() == 100));
        assertTrue(database.availableBuns().stream()
                .anyMatch(bun -> bun.getName().equals("white bun") && bun.getPrice() == 200));
        assertTrue(database.availableBuns().stream()
                .anyMatch(bun -> bun.getName().equals("red bun") && bun.getPrice() == 300));
    }

    @Test
    public void testIngredientsContent() {
        Database database = new Database();
        
        assertTrue(database.availableIngredients().stream()
                .anyMatch(ing -> ing.getName().equals("hot sauce") && ing.getType() == IngredientType.SAUCE));
        assertTrue(database.availableIngredients().stream()
                .anyMatch(ing -> ing.getName().equals("cutlet") && ing.getType() == IngredientType.FILLING));
    }
} 