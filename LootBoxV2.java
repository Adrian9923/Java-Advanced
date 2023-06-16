package ExamPreparation;

import java.util.*;

public class LootBoxV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> claimedItems = new ArrayList<>();
        ArrayDeque<Integer> queueFirstBox = new ArrayDeque<>();
        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();

        int[] array1 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] array2 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i : array1) {
            queueFirstBox.add(i);
        }
        for (int i : array2) {
            stackSecondBox.push(i);
        }

        while (!((queueFirstBox.isEmpty()) || (stackSecondBox.isEmpty()))) {

            int firstNumber = queueFirstBox.peek();
            int lastNumber = stackSecondBox.peek();
            int sum = firstNumber + lastNumber;
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                queueFirstBox.poll();
                stackSecondBox.pop();
            }else {
                queueFirstBox.add(stackSecondBox.pop());
            }

        }
        if (queueFirstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }
        int sum = 0;
        for (Integer claimedItem : claimedItems) {
            sum += claimedItem;
        }
        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d",sum);
        }else {
            System.out.printf("Your loot was poor... Value: %d",sum);
        }


    }
}
