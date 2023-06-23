package HomeWork;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equals("stop")) {

            String email = scanner.nextLine();
            String[] emailParts = email.split("@");
            String[] tokens = emailParts[1].split("\\.");
            String domain = tokens[1];
            if (!(domain.equals("US") || domain.equals("UK") || domain.equals("com") || domain.equals("us") || domain.equals("uk")))  {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s\n",entry.getKey(), entry.getValue());
        }

    }
}
