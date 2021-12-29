package RandomArrayList_4;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    public Object getRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.get(index);
    }
}