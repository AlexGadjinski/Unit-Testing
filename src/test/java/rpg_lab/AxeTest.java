package rpg_lab;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static rpg_lab.Axe.DURABILITY_LOST;

public class AxeTest {
    private static final Dummy DUMMY = Mockito.mock(Dummy.class);
    private static final int ATTACK = 10;
    private static final int DURABILITY = 50;

    @Test
    public void test_AxeLosesDurability_OnAttack() {
        // Arrange
        Axe axe = new Axe(ATTACK, DURABILITY);
        // Act
        axe.attack(DUMMY);
        // Assert
        assertEquals(DURABILITY - DURABILITY_LOST, axe.getDurabilityPoints());
    }

    @Test
    public void test_AxeAttack_WhenBroken_Throws() {
        Axe brokenAxe = new Axe(10, 0);
        IllegalStateException ex =
                assertThrows(IllegalStateException.class, () -> brokenAxe.attack(DUMMY));
        assertEquals("Axe is broken.", ex.getMessage());
    }
}
