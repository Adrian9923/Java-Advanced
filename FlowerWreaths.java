package Exam;

import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flowerWreaths = 5;

        List<Integer> storedFlowers = new ArrayList<>();
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();

        int[] array1 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] array2 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i : array1) {
            lilies.push(i);
        }
        for (int i : array2) {
            roses.add(i);
        }

        while (!((lilies.isEmpty()) || (roses.isEmpty()))) {
            int lillie = lilies.peek();
            int rose = roses.peek();
            int sum = lillie + rose;
            if (sum > 15) {
                int newValue = lillie - 2;
                lilies.pop();
                lilies.push(newValue);
            }
            if (sum == 15){
                flowerWreaths--;
                lilies.pop();
                roses.poll();
            }
            if (sum < 15){
                storedFlowers.add(sum);
                lilies.pop();
                roses.poll();
            }
        }

        int totalFlowers = 0;
        for (Integer storedFlower : storedFlowers) {
            totalFlowers += storedFlower;
        }

        flowerWreaths -= totalFlowers / 15;
        if (flowerWreaths <= 0) {
            System.out.println("You made it, you are going to the competition with 5 wreaths!");
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!",flowerWreaths);
        }

    }
}
