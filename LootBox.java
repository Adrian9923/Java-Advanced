package ExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> claimedItems = new ArrayList<>();
        List<Integer> firstLootBox= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondLootBox= Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while (!(firstLootBox.isEmpty() || secondLootBox.isEmpty())) {
            int firstItem = firstLootBox.get(0);
            int lastItem = secondLootBox.get(secondLootBox.size() - 1);
            int sum = firstItem + lastItem;
            if (sum % 2 == 0){
                claimedItems.add(sum);
                firstLootBox.remove(0);
                secondLootBox.remove(secondLootBox.size() - 1);
            }else {
                secondLootBox.remove(secondLootBox.size() - 1);
                firstLootBox.add(lastItem);
            }

        }
        int sumClaimedItems = 0;
        for (Integer claimedItem : claimedItems) {
            sumClaimedItems += claimedItem;
        }


        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }
        if (sumClaimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d\n",sumClaimedItems);
        }else {
            System.out.printf("Your loot was poor... Value: %d\n",sumClaimedItems);
        }
    }
}
