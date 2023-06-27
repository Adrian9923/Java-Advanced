package HomeWork;

import java.util.*;

public class LogsAggregatorV2 {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> data = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] logsInfo = scanner.nextLine().split(" ");
            String ip = logsInfo[0];
            String user = logsInfo[1];
            int duration = Integer.parseInt(logsInfo[2]);

            if (!data.containsKey(user)) {
                data.put(user, new TreeMap<>());
            }
            if (!data.get(user).containsKey(ip)) {
                data.get(user).put(ip, 0);
            }

            data.get(user).put(ip, data.get(user).get(ip) + duration);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();

            System.out.print(entry.getKey() + ": " + sum + " ");
            System.out.print("[");
            System.out.print(String.join(", ", entry.getValue().keySet()));
            System.out.println("]");
        }
    }
}

