import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyTest {

    private static List<PokerHand> handsTest = new ArrayList<>();
    private List<PokerHand> twoArms = new ArrayList<>();

    int resultCompareTo;

    @BeforeAll
    public static void createHands() {
        handsTest.add(new PokerHand("JS KH TC 5D 3D"));
        handsTest.add(new PokerHand("2C 2S AC 4C 5C"));
        handsTest.add(new PokerHand("2C 2S AC 4C 4S"));
        handsTest.add(new PokerHand("2C 2S 2H 4C TC"));
        handsTest.add(new PokerHand("2C 3S 5H 4C 6D"));
        handsTest.add(new PokerHand("2C 3C 4C 6C 5C"));
        handsTest.add(new PokerHand("AC 6D 6H 6S AS"));
        handsTest.add(new PokerHand("KS KH KC KD 5D"));
        handsTest.add(new PokerHand("2C 3C 6C 4C 5C"));
        handsTest.add(new PokerHand("TC QC JC KC AC"));
    }

    @BeforeEach
    public void handsTwo() {
//        twoArms.clear();
    }

    @Test
    public void strongestHandShouldBeSelected() {
        for (int i = 0; i < handsTest.size(); i++) {
            for (int j = i + 1; j < handsTest.size(); j++) {
                twoArms.clear();
                twoArms.add(handsTest.get(i));
                twoArms.add(handsTest.get(j));
                System.out.println(twoArms.get(0).getHand() + twoArms.get(1).getHand());
                Assertions.assertEquals(twoArms.get(0).compareTo(twoArms.get(1)), -1);
            }
        }
    }
}
