public class PokerHand implements Comparable<PokerHand>{
    private String hand;

    public PokerHand(String hand) {
        this.hand = hand;
    }

    public String getHand() {
        return hand;
    }

    @Override
    public int compareTo(PokerHand o) {
        return 0;
    }
}
