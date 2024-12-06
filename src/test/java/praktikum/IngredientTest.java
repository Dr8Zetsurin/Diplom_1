package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    
    private final IngredientType type;
    private final String name;
    private final float price;
    
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
            {IngredientType.SAUCE, "hot sauce", 100.0f},
            {IngredientType.FILLING, "cutlet", 200.0f},
            {IngredientType.SAUCE, "chili sauce", 300.0f},
            {IngredientType.FILLING, "sausage", 300.0f}
        };
    }
    
    @Test
    public void testIngredientCreation() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.01);
    }
} 