package lab11.baitap.bai3.card;

import java.util.Random;

public class ShuffleCard {
    public Card[][] cards;

    public ShuffleCard(Card[][] arr) {
        this.cards = arr;
    }

    public ShuffleCard() {
    }

    public void shuffle(Card[][] cards) {
        Random rand = new Random();

        // Duyệt qua từng phần tử của mảng
        for (int i = cards.length - 1; i > 0; i--) {
            for (int j = cards[i].length - 1; j > 0; j--) {
                // Tạo vị trí ngẫu nhiên để trộn
                int randRow = rand.nextInt(i + 1);
                int randCol = rand.nextInt(j + 1);

                // Swap array[i][j] with array[randRow][randCol]
                Card temp = cards[i][j];
                cards[i][j] = cards[randRow][randCol];
                cards[randRow][randCol] = temp;
            }
        }
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

    public static void main(String[] args) {
//        Card[][] cards = read();
//        print(cards);
//        shuffle(cards);
//        System.out.println();
//        print(cards);

        ShuffleCard shuffleCard = new ShuffleCard();
        shuffleCard.cards = shuffleCard.read();
        shuffleCard.print(shuffleCard.cards);
        System.out.println();
        shuffleCard.shuffle(shuffleCard.cards);
        shuffleCard.print(shuffleCard.cards);
    }
}
