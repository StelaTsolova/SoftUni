package BubbleSortTest_4;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSortCorrect() {
        int[] arr = new int[]{12, 15, 5, 78, 63};
        int[] sortedArr = new int[]{5, 12, 15, 63, 78};

        Bubble.sort(arr);

        Assert.assertArrayEquals(sortedArr, arr);
    }
}