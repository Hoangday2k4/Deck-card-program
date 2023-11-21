package lab11.baitap.bai3.card;

public class CardManager {
    public static void main(String[] args) {
        Card[][] array = new Card[4][13];
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= 13; j++) {
                array[array.length - i][j - 1] = new Card(convertRank(j), convertSuit(i));
            }
        }
        print(array);
    }

    public static String convertSuit(int i) {
        if (i == 1) {
            return "spades";
        } else if (i == 2) {
            return "clovers";
        } else if (i == 3) {
            return "diamonds";
        } else {
            return "hearts";
        }
    }

    public static String convertRank(int i) {
        if (i == 1) {
            return "A";
        } else if (i == 11) {
            return "J";
        } else if (i == 12) {
            return "Q";
        } else if (i == 13) {
            return "K";
        } else {
            return String.valueOf(i);
        }
    }

    public static void print(Card[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j].toString() + ", ");
            }
            System.out.println();
        }
    }
}
