package AssociativeArrays;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double[]> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double[] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::valueOf)
                    .toArray(Double[]::new);
            students.put(name, grades);
        }

        for (Map.Entry<String, Double[]> entry : students.entrySet()) {
            double average  = Arrays.stream(entry.getValue())
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);

            DecimalFormat decimalFormat = new DecimalFormat("0.###");

            System.out.printf("%s graduated with %s\n",entry.getKey(), decimalFormat.format(average));
        }

    }
}
