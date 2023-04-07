import java.util.*;

public class PokerHand implements Comparable<PokerHand>{
    private String hand;

    public PokerHand(String hand) {
        this.hand = hand;
    }

    public String getHand() {
        return hand;
    }

    private int charToInt(char c) {
        switch (c) {
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14;
            default: return Integer.parseInt(String.valueOf(c));
        }
    }

    @Override
    public int compareTo(PokerHand o) {
        List<String> h1 = new ArrayList<>(List.of(o.getHand().split(" ")));
        List<String> h2 = new ArrayList<>(List.of(this.getHand().split(" ")));
        Map<Character, Integer> suit1= new TreeMap<>();
        Map<Character, Integer> suit2= new TreeMap<>();
        Map<Integer, Integer> value1= new TreeMap<>();
        Map<Integer, Integer> value2= new TreeMap<>();
        for (int i = 0; i < 5; i++) {
            if (suit1.containsKey(h1.get(i).charAt(1))) {
                suit1.put(h1.get(i).charAt(1), suit1.get(h1.get(i).charAt(1)) + 1);
            } else {
                suit1.put(h1.get(i).charAt(1), 1);
            }
            if (suit2.containsKey(h2.get(i).charAt(1))) {
                suit2.put(h2.get(i).charAt(1), suit2.get(h2.get(i).charAt(1)) + 1);
            } else {
                suit2.put(h2.get(i).charAt(1), 1);
            }
            if (value1.containsKey(charToInt(h1.get(i).charAt(0)))) {
                value1.put(charToInt(h1.get(i).charAt(0)), value1.get(charToInt(h1.get(i).charAt(0))) + 1);
            } else {
                value1.put(charToInt(h1.get(i).charAt(0)), 1);
            }
            if (value2.containsKey(charToInt(h2.get(i).charAt(0)))) {
                value2.put(charToInt(h2.get(i).charAt(0)), value2.get(charToInt(h2.get(i).charAt(0))) + 1);
            } else {
                value2.put(charToInt(h2.get(i).charAt(0)), 1);
            }
        }
        System.out.println(suit1.entrySet());
        System.out.println(value1.entrySet());
        System.out.println(suit2.entrySet());
        System.out.println(value2.entrySet());

        int rating1;
        if (suit1.size() == 1 && value1.size() == 5 && value1.keySet().stream().mapToInt(key -> value1.get(key)).sum() == 60) {
            rating1 = 10;
        } else {

        }

        return 0;
    }
}
