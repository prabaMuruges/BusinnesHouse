import com.company.Board;
import com.company.Cell;
import com.company.Jail;
import com.company.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
public class BoardTest {
    @Test
    public void testProcess(){
        Player player = new Player("Praba", 1000);

        Cell cell = new Jail(1, 100);
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(cell);

        Board board = new Board(cells);
        board.process(player, 1);

        Assert.assertEquals(cell, player.getCurrentCell().get());
    }
}
