import com.company.*;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PlayerTest {

    @Test
    public void testMoveToHotelWithoutOwner() {
        Hotel cell = mock(Hotel.class);
        when(cell.hasOwner()).thenReturn(false);

        Player player = new Player("Praba", 1000);
        int oldWorth = player.getWorth();

        player.moveTo(cell);
        Assert.assertTrue(player.getCurrentCell().get().equals(cell));
        Assert.assertEquals(oldWorth - cell.getValue(), player.getWorth());
    }

    @Test
    public void testMoveToHotelWithOwner() {
        Hotel cell = mock(Hotel.class);
        when(cell.hasOwner()).thenReturn(true);

        Player player = new Player("Praba", 1000);
        Player owner = new Player("Owner", 1000);

        when(cell.getOwner()).thenReturn(owner);
        int oldWorth = player.getWorth();

        player.moveTo(cell);
        Assert.assertTrue(player.getCurrentCell().get().equals(cell));
        Assert.assertEquals(oldWorth - cell.getRent(), player.getWorth());
    }

    @Test
    public void testMoveToJail() {
        Cell cell = new Jail(1, 100);

        Player player = new Player("Praba", 1000);
        int oldWorth = player.getWorth();

        player.moveTo(cell);
        Assert.assertTrue(player.getCurrentCell().get().equals(cell));
        Assert.assertEquals(oldWorth - cell.getValue(), player.getWorth());
    }

    @Test
    public void testMoveToTreasure() {
        Cell cell = new Treasure(1, 100);

        Player player = new Player("Praba", 1000);
        int oldWorth = player.getWorth();

        player.moveTo(cell);
        Assert.assertTrue(player.getCurrentCell().get().equals(cell));
        Assert.assertEquals(oldWorth + cell.getValue(), player.getWorth());
    }

    @Test
    public void testMoveToEmptyCell() {
        Cell cell = new Empty(1);

        Player player = new Player("Praba", 1000);
        int oldWorth = player.getWorth();

        player.moveTo(cell);
        Assert.assertTrue(player.getCurrentCell().get().equals(cell));
        Assert.assertEquals(oldWorth, player.getWorth());
    }
}
