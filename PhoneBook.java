package HomeWork;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contacts = new LinkedHashMap<>();

        boolean itExist = false;
        String command = scanner.nextLine();
        while (!command.equals("search")) {

            String[] cmdParts = command.split("-");
            String name = cmdParts[0];
            String number = cmdParts[1];

            if (!contacts.containsKey(name)) {
                contacts.put(name, number);
            }else {
                contacts.put(name, number);
            }

            command = scanner.nextLine();
        }
        String command2 = scanner.nextLine();
        while (!command2.equals("stop")) {
            String name = "";
            String number = "";

            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                if (entry.getKey().contains(command2)) {
                    itExist = true;
                    name = entry.getKey();
                    number = entry.getValue();
                    break;
                }else {
                    itExist = false;
                }
            }

            if (itExist) {
                System.out.printf("%s -> %s\n",name, number);
            }else {
                System.out.printf("Contact %s does not exist.\n",command2);
            }
            command2 = scanner.nextLine();
        }
    }
}
