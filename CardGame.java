package Sets;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> player1Deck = new LinkedHashSet<>();
        Set<Integer> player2Deck = new LinkedHashSet<>();

        int[] array1 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] array2 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i : array1) {
            player1Deck.add(i);
        }
        for (int i : array2) {
            player2Deck.add(i);
        }

        int i = 1;
        while (i <= 50 || player1Deck.isEmpty() || player2Deck.isEmpty()) {

            int firstNumber = player1Deck.iterator().next();
            player1Deck.remove(firstNumber);

            int secondNumber = player2Deck.iterator().next();
            player2Deck.remove(secondNumber);

            if (firstNumber > secondNumber) {
                player1Deck.add(firstNumber);
                player1Deck.add(secondNumber);
            }else {
                player2Deck.add(firstNumber);
                player2Deck.add(secondNumber);
            }


            i++;
        }

        if (player1Deck.size() > player2Deck.size()) {
            System.out.println("First player wins!");
        }else {
            System.out.println("Second player wins!");
        }

    }
}
