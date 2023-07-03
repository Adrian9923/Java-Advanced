package HomeWork;

import java.util.*;

public class UserLogsV3BUN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeMap<String, LinkedHashMap<String, Integer>> userDict = new TreeMap<>();

        while (!input[0].equals("end")) {
            String user = input[2].substring(5);
            String IP = input[0].substring(3);

            if (!userDict.containsKey(user)) { // new USER
                userDict.put(user, new LinkedHashMap<>());
                userDict.get(user).put(IP, 1);
            } else { // existing user : 2 cases
                if (userDict.get(user).containsKey(IP)) { // existing USER, existing IP
                    userDict.get(user).put(IP, userDict.get(user).get(IP) + 1);
                } else { // existing USER, new IP
                    userDict.get(user).put(IP, 1);
                }
            }
            input = scanner.nextLine().split(" ");
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : userDict.entrySet()) {
            String ipAddress = "";
            List<String> ipRow = new ArrayList<>();

            for (String ip : user.getValue().keySet()) {
                ipAddress = ip + " => " + user.getValue().get(ip);
                ipRow.add(ipAddress);
            }
            ipAddress = String.join(", ", ipRow);
            System.out.println(user.getKey() + ":");
            System.out.println(ipAddress + ".");
        }
    }
}
