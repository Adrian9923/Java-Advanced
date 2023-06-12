package Sets;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CardGameV2 {
    public static void main(String[] args) {

        Set<Integer> firstPlayer = getPlayerNumbers();
        Set<Integer> secondPlayer = getPlayerNumbers();

        for (int i = 0; i < 50; i++) {
            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            }else {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player wins!");
        }else {
            System.out.println("Second player wins!");
        }
    }


    public static Set<Integer> getPlayerNumbers() {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        return new LinkedHashSet<>(Arrays.asList(numbers));
    }
}
