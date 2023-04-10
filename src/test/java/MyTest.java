import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
        handsTest.add(new PokerHand("2C 3C TC AC 6C"));
        handsTest.add(new PokerHand("AC 6D 6H 6S AS"));
        handsTest.add(new PokerHand("KS KH KC KD 5D"));
        handsTest.add(new PokerHand("2C 3C 6C 4C 5C"));
        handsTest.add(new PokerHand("TC QC JC KC AC"));
    }

    @BeforeEach
    public void handsTwo() {
        twoArms.clear();
    }

    static Stream<Arguments> provideArgumentsAsc() {

        return Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).flatMap(x -> Stream.of(arguments(x, x + 1)));
    }

    static Stream<Arguments> provideArgumentsDesc() {

        return Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).flatMap(x -> Stream.of(arguments(x + 1, x)));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsAsc")
    public void strongestHandShouldBeSelectedDesc(int i, int j) {

                twoArms.add(handsTest.get(i));
                twoArms.add(handsTest.get(j));
                System.out.println(twoArms.get(0).getHand() + twoArms.get(1).getHand());
                assertEquals(twoArms.get(0).compareTo(twoArms.get(1)), -1);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsDesc")
    public void strongestHandShouldBeSelectedAsc(int i, int j) {

        twoArms.add(handsTest.get(i));
        twoArms.add(handsTest.get(j));
        System.out.println(twoArms.get(0).getHand() + twoArms.get(1).getHand());
        assertEquals(twoArms.get(0).compareTo(twoArms.get(1)), 1);
    }
}
