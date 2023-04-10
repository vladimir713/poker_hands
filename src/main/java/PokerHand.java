/**
 * @author Vladimir Chugunov
 */

import java.util.*;

public record PokerHand(String hand) implements Comparable<PokerHand> {

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

    private int getRating(TreeMap<Character, Integer> suit, TreeMap<Integer, Integer> value) {
        if (suit.size() == 1 && value.keySet().stream().mapToInt(Integer::intValue).sum() == 60) {
            return 10;
        }
        if (suit.size() == 1 && (value.lastKey() - value.firstKey()) == 4) {
            return 9;
        }
        if (suit.size() == 4 && value.containsValue(4)) {
            return 8;
        }
        if (value.containsValue(2) && value.containsValue(3)) {
            return 7;
        }
        if (suit.size() == 1) {
            return 6;
        }
        if (value.size() == 5 && (value.lastKey() - value.firstKey()) == 4) {
            return 5;
        }
        if (value.containsValue(3)) {
            return 4;
        }
        if (value.containsValue(2) && value.size() == 3) {
            return 3;
        }
        if (value.containsValue(2) && value.size() == 4) {
            return 2;
        }
        return 1;
    }

    @Override
    public int compareTo(PokerHand o) {
        List<String> h1 = new ArrayList<>(List.of(o.hand().split(" ")));
        List<String> h2 = new ArrayList<>(List.of(this.hand().split(" ")));
        TreeMap<Character, Integer> suit1 = new TreeMap<>();
        TreeMap<Character, Integer> suit2 = new TreeMap<>();
        TreeMap<Integer, Integer> value1 = new TreeMap<>();
        TreeMap<Integer, Integer> value2 = new TreeMap<>();

        for (int i = 0; i < 5; i++) {
            setSuitOneOrInc(h1, suit1, i);
            setSuitOneOrInc(h2, suit2, i);
            setValueOneOrInc(h1, value1, i);
            setValueOneOrInc(h2, value2, i);
        }

        return Integer.compare(getRating(suit1, value1), getRating(suit2, value2));
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
