package HomeWork;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] components = Arrays.stream(scanner.nextLine().split(" "))
                    .toArray(String[]::new);
            for (String component : components) {
                elements.add(component);
            }

        }

        for (String element : elements) {
            System.out.print(element + " ");
        }

    }
}
