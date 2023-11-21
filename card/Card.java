package lab11.baitap.bai3.card;

public class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.rank + '_' + this.suit;
    }


    public int convertSuit(String suit) {
        if (suit.equals("spades")) {
            return 1;
        } else if (suit.equals("clovers")) {
            return 2;
        } else if (suit.equals("diamonds")) {
            return 3;
        } else {
            return 4;
        }
    }

    public int convertRank(String rank) {
        if (rank.equals("A")) {
            return 1;
        } else if (rank.equals("J")) {
            return 11;
        } else if (rank.equals("Q")) {
            return 12;
        } else if (rank.equals("K")) {
            return 13;
        } else {
            return Integer.parseInt(rank);
        }
    }

    @Override
    public int compareTo(Card o) {
        if (convertRank(this.getRank()) > convertRank(((Card)o).getRank())) {
            return 1;
        } else {
            if (convertRank(this.getRank()) == convertRank(((Card)o).getRank())) {
                if (convertSuit(this.getSuit()) > convertSuit(((Card)o).getSuit())) {
                    return 1;
                } else {
                    if (convertSuit(this.getSuit()) == convertSuit(((Card)o).getSuit())) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
            else {
                return -1;
            }
        }
    }
}
