import com.company.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by praba on 18/02/18.
 */
public class BusinessHouseTest {
    @Test
    public void testGaming(){
        int[] diceInputs = {1,1,1,1,1,1,1,1};

        ArrayList<Player> players = new ArrayList<>();
        Player tom = new Player("Tom", 1000);
        players.add(tom);
        Player john = new Player("John", 1000);
        players.add(john);

        BusinessHouse testGame = new BusinessHouse(new Board(getCells()), players, diceInputs);
        testGame.start();

        Assert.assertEquals(900, tom.getWorth());
        Assert.assertEquals(1100, tom.getNetWorth());
        Assert.assertEquals(1000, john.getNetWorth());
        Assert.assertEquals(1000, john.getWorth());
    }

    private ArrayList<Cell> getCells() {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(new Jail(1, 150));
        cells.add(new Hotel(2, 200, 50));
        cells.add(new Treasure(3, 200));
        cells.add(new Empty(4));
        return cells;
    }
}
