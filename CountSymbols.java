package HomeWork;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> counts = new TreeMap<>();

        String line = scanner.nextLine();
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if (!counts.containsKey(letter)) {
                counts.put(letter, 1);
            }else {
                counts.put(letter, counts.get(letter) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%c: %d time/s\n",entry.getKey(), entry.getValue());
        }

    }
}
