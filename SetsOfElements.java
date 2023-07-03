package HomeWork;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> firstList = new LinkedHashSet<>();
        Set<String> secondList = new LinkedHashSet<>();

        int[] length = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sizeList1 = length[0];
        int sizeList2 = length[1];

        for (int i = 0; i < sizeList1; i++) {
            String number = scanner.nextLine();
            firstList.add(number);
        }

        for (int i = 0; i < sizeList2; i++) {
            String number = scanner.nextLine();
            secondList.add(number);
        }

        for (String s : firstList) {
            if (secondList.contains(s))
            {
                System.out.print(s + " ");
            }
        }

    }
}
