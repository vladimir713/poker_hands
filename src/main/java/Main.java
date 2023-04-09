import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PokerHand> hands = new ArrayList<>();
        hands.add(new PokerHand("KS KH 5C 5D 5D"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));
        Collections.sort(hands);
        for (PokerHand ph: hands) {
            System.out.println(ph.getHand());
        }
    }

}
