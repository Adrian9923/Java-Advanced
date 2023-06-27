package HomeWork;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> userAndIp = new TreeMap<>();
        Map<String, Integer> userAndDuration = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] cmdParts = command.split("\\s+");
            String ip = cmdParts[0];
            String name = cmdParts[1];
            int duration = Integer.parseInt(cmdParts[2]);

            if (!userAndIp.containsKey(name)) {
                userAndIp.put(name, new TreeSet<>());
                userAndIp.get(name).add(ip);
            }else {
                userAndIp.get(name).add(ip);
            }

            if (!userAndDuration.containsKey(name)) {
                userAndDuration.put(name, duration);
            }else {
                userAndDuration.put(name, userAndDuration.get(name) + duration);
            }
        }
        for (Map.Entry<String, Integer> entry : userAndDuration.entrySet()) {
            System.out.printf("%s: %d ",entry.getKey(),entry.getValue());
            for (Map.Entry<String, Set<String>> entry2 : userAndIp.entrySet()) {
                if (entry2.getKey().equals(entry.getKey())) {
                    System.out.printf("[%s]\n", String.join(", ", entry2.getValue()));
                    break;
                }
            }

        }

    }
}
