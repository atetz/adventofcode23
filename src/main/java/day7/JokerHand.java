package day7;

import java.util.HashMap;
import java.util.Map;

public class JokerHand implements Comparable<JokerHand> {
    String cards;
    int bid;
    int strength;

    private static final HashMap<String, Integer> strengthMap = new HashMap<>();

    static {
        strengthMap.put("5_OF_KIND", 7);
        strengthMap.put("4_OF_KIND", 6);
        strengthMap.put("FULL_HOUSE", 5);
        strengthMap.put("3_OF_KIND", 4);
        strengthMap.put("2_PAIR", 3);
        strengthMap.put("1_PAIR", 2);
        strengthMap.put("HIGH_CARD", 1);
    }

    private static final HashMap<Character, Integer> deck = new HashMap<>();

    static {
        deck.put('J', 1);
        deck.put('2', 2);
        deck.put('3', 3);
        deck.put('4', 4);
        deck.put('5', 5);
        deck.put('6', 6);
        deck.put('7', 7);
        deck.put('8', 8);
        deck.put('9', 9);
        deck.put('T', 10);
        deck.put('Q', 12);
        deck.put('K', 13);
        deck.put('A', 14);
    }

    public JokerHand(String cards, int bid) {
        this.cards = cards;
        this.bid = bid;
        setPower();
    }

    private Map<Character, Integer> createCardDuplicateMap() {
        Map<Character, Integer> duplicateCards = new HashMap<>();
        for (Character c : cards.toCharArray()) {
            duplicateCards.put(c, duplicateCards.getOrDefault(c, 0) + 1);
        }
        return duplicateCards;
    }

    private void setPower() {
        Map<Character, Integer> duplicateCards = createCardDuplicateMap();

        int currentStrength = strengthMap.get("HIGH_CARD");

        for (Map.Entry<Character, Integer> entry : duplicateCards.entrySet()) {
            int duplicates = entry.getValue();
            if (entry.getKey() == 'J') {
                continue;
            }
            if (duplicates == 5) {
                currentStrength = strengthMap.get("5_OF_KIND");

            } else if (duplicates == 4) {
                currentStrength = strengthMap.get("4_OF_KIND");

            } else if (duplicates == 3) {
                if (currentStrength == strengthMap.get("1_PAIR")) {
                    currentStrength = strengthMap.get("FULL_HOUSE");
                } else {
                    currentStrength = strengthMap.get("3_OF_KIND");
                }
            } else if (duplicates == 2) {
                if (currentStrength == strengthMap.get("3_OF_KIND")) {
                    currentStrength = strengthMap.get("FULL_HOUSE");
                } else if (currentStrength == strengthMap.get("1_PAIR")) {
                    currentStrength = strengthMap.get("2_PAIR");
                } else {
                    currentStrength = strengthMap.get("1_PAIR");
                }
            }
        }

        int numOfJokers = duplicateCards.getOrDefault('J', 0);
        if (currentStrength == strengthMap.get("HIGH_CARD")) {
            if (numOfJokers == 1) {
                currentStrength = strengthMap.get("1_PAIR");
            } else if (numOfJokers == 2) {
                currentStrength = strengthMap.get("3_OF_KIND");
            } else if (numOfJokers == 3) {
                currentStrength = strengthMap.get("4_OF_KIND");
            } else if (numOfJokers == 4) {
                currentStrength = strengthMap.get("5_OF_KIND");
            } else if (numOfJokers == 5) {
                currentStrength = strengthMap.get("5_OF_KIND");
            }
        } else if (currentStrength == strengthMap.get("1_PAIR")) {
            if (numOfJokers == 1) {
                currentStrength = strengthMap.get("3_OF_KIND");
            } else if (numOfJokers == 2) {
                currentStrength = strengthMap.get("4_OF_KIND");
            } else if (numOfJokers == 3) {
                currentStrength = strengthMap.get("5_OF_KIND");
            }
        } else if (currentStrength == strengthMap.get("2_PAIR")) {
            if (numOfJokers == 1) {
                currentStrength = strengthMap.get("FULL_HOUSE");
            }
        } else if (currentStrength == strengthMap.get("3_OF_KIND")) {
            if (numOfJokers == 1) {
                currentStrength = strengthMap.get("4_OF_KIND");
            } else if (numOfJokers == 2) {
                currentStrength = strengthMap.get("5_OF_KIND");

            }
        } else if (currentStrength == strengthMap.get("4_OF_KIND")) {
            if (numOfJokers == 1) {
                currentStrength = strengthMap.get("5_OF_KIND");
            }
        }
        strength = currentStrength;
    }

    public String getCards() {
        return cards;
    }

    public int getBid() {
        return bid;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public int compareTo(JokerHand o) {

        if (strength > o.getStrength()) {
            return 1;
        } else if (strength < o.getStrength()) {
            return -1;
        }

        for (int i = 0; i < cards.length(); i++) {
            int currentCard = deck.get(cards.charAt(i));
            int opponentCard = deck.get(o.getCards().charAt(i));

            if (currentCard > opponentCard) {
                return 1;
            } else if (currentCard < opponentCard) {
                return -1;
            }
        }
        return 0;
    }
}

