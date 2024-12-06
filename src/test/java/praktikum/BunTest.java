package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    
    private final String name;
    private final float price;
    
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
            {"black bun", 100.0f},
            {"white bun", 200.0f},
            {"red bun", 300.0f}
        };
    }
    
    @Test
    public void testBunCreation() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.01);
    }
} 