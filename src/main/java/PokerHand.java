/**
 * @author Vladimir Chugunov
 */

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

    private int getRating(TreeMap<Character, Integer> suit, TreeMap<Integer, Integer> value){

        if (suit.size() == 1 && value.keySet().stream().mapToInt(Integer::intValue).sum() == 60) {
            return  10;
        } else if (suit.size() == 1 && (value.lastKey() - value.firstKey()) == 4) {
            return  9;
        } else if (suit.size() == 4 && value.containsValue(4)) {
            return  8;
        } else if (value.containsValue(2) && value.containsValue(3)) {
            return  7;
        } else if (suit.size() == 1) {
            return  6;
        } else if (value.size() == 5 && (value.lastKey() - value.firstKey()) == 4) {
            return  5;
        } else if (value.containsValue(3)) {
            return  4;
        } else if (value.containsValue(2) && value.size() == 3) {
            return  3;
        } else if (value.containsValue(2) && value.size() == 4) {
            return  2;
        } else return  1;
    }
    @Override
    public int compareTo(PokerHand o) {
        List<String> h1 = new ArrayList<>(List.of(o.getHand().split(" ")));
        List<String> h2 = new ArrayList<>(List.of(this.getHand().split(" ")));
        TreeMap<Character, Integer> suit1= new TreeMap<>();
        TreeMap<Character, Integer> suit2= new TreeMap<>();
        TreeMap<Integer, Integer> value1= new TreeMap<>();
        TreeMap<Integer, Integer> value2= new TreeMap<>();

        for (int i = 0; i < 5; i++) {
            setSuitOneOrInc(h1, suit1, i);
            setSuitOneOrInc(h2, suit2, i);
            setValueOneOrInc(h1, value1, i);
            setValueOneOrInc(h2, value2, i);
        }

        if (getRating(suit1, value1) > getRating(suit2, value2)) {
            return 1;
        } else if (getRating(suit1, value1) < getRating(suit2, value2)) {
            return -1;
        } else return 0;
    }

    private void setValueOneOrInc(List<String> h, TreeMap<Integer, Integer> value, int i) {
        if (value.containsKey(charToInt(h.get(i).charAt(0)))) {
            value.put(charToInt(h.get(i).charAt(0)), value.get(charToInt(h.get(i).charAt(0))) + 1);
        } else {
            value.put(charToInt(h.get(i).charAt(0)), 1);
        }
    }

    private void setSuitOneOrInc(List<String> h, TreeMap<Character, Integer> suit, int i) {
        if (suit.containsKey(h.get(i).charAt(1))) {
            suit.put(h.get(i).charAt(1), suit.get(h.get(i).charAt(1)) + 1);
        } else {
            suit.put(h.get(i).charAt(1), 1);
        }
    }
}
