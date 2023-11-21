package lab11.baitap.bai3.card;

import lab11.baitap.bai2.BubbleSort;

public class SortCard {
    public Card[][] cards;

    public void sort(Card[] cards) {
        BubbleSort<Card> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(cards);
    }

    public Card[][] read() {
        Card[][] array = new Card[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = new Card(String.valueOf(i), String.valueOf(j));
            }
        }
        return array;
    }

    public void print(Card[][] cards) {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                System.out.print(cards[i][j] + " ");
            }
            System.out.println();
        }
    }
}
