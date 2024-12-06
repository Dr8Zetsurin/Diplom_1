package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        
        // Настраиваем поведение моков
        when(mockBun.getName()).thenReturn("MockBun");
        when(mockBun.getPrice()).thenReturn(100.0f);
        
        when(mockIngredient1.getName()).thenReturn("MockIngredient1");
        when(mockIngredient1.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        
        when(mockIngredient2.getName()).thenReturn("MockIngredient2");
        when(mockIngredient2.getPrice()).thenReturn(75.0f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        // Цена = (цена булки * 2) + цена ингредиента1 + цена ингредиента2
        float expectedPrice = (100.0f * 2) + 50.0f + 75.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("MockBun"));
        assertTrue(receipt.contains("MockIngredient1"));
        assertTrue(receipt.contains("sauce"));
    }

    @Test
    public void testGetPriceWithNoIngredients() {
        burger.setBuns(mockBun);
        assertEquals(200.0f, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceiptWithNoIngredients() {
        burger.setBuns(mockBun);
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("MockBun"));
        assertTrue(receipt.contains("Price: 200"));
    }

    @Test
    public void testMoveIngredientToSamePosition() {
        burger.addIngredient(mockIngredient1);
        burger.moveIngredient(0, 0);
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientWithInvalidIndex() {
        burger.removeIngredient(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientWithInvalidIndex() {
        burger.moveIngredient(0, 1);
    }
}
