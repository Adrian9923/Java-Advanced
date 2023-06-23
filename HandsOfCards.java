package HomeWork;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> values = new LinkedHashMap<>();
        Set<String> list = new LinkedHashSet<>();

        int result = 0;
        String command = scanner.nextLine();
        while (!command.equals("JOKER")) {


            String[] cmdParts = command.split(": ");
            String name = cmdParts[0];
            String[] array = Arrays.stream(cmdParts[1].split(", "))
                    .toArray(String[]::new);

            for (String s : array) {
                list.add(s);
            }

            for (String s : list) {
                if (s.length() == 2) {
                    for (int i = 0; i < s.length() - 1; i++) {
                        char power = s.charAt(i);
                        char type = s.charAt(i + 1);
                        switch (power) {
                            case '2': {
                                power = 2;
                                break;
                            }
                            case '3': {
                                power = 3;
                                break;
                            }
                            case '4': {
                                power = 4;
                                break;
                            }
                            case '5': {
                                power = 5;
                                break;
                            }
                            case '6': {
                                power = 6;
                                break;
                            }
                            case '7': {
                                power = 7;
                                break;
                            }
                            case '8': {
                                power = 8;
                                break;
                            }
                            case '9': {
                                power = 9;
                                break;
                            }
                            case 'J': {
                                power = 11;
                                break;
                            }
                            case 'Q': {
                                power = 12;
                                break;
                            }
                            case 'K': {
                                power = 13;
                                break;
                            }
                            case 'A': {
                                power = 14;
                                break;
                            }
                        }
                        switch (type) {
                            case 'S': {
                                type = 4;
                                break;
                            }
                            case 'H': {
                                type = 3;
                                break;
                            }
                            case 'D': {
                                type = 2;
                                break;
                            }
                            case 'C': {
                                type = 1;
                                break;
                            }
                        }
                        result += power * type;
                    }
                }else if (s.length() == 3) {
                    for (int i = 0; i < s.length() - 2; i++) {
                        char firstLetter = s.charAt(i);
                        char secondLetter = s.charAt(i + 1);
                        String combined = "" + firstLetter + secondLetter;
                        char type = s.charAt(i + 2);
                        char power = 0;
                        if (combined.equals("10")) {
                            power = 10;
                        }
                        switch (type) {
                            case 'S': {
                                type = 4;
                                break;
                            }
                            case 'H': {
                                type = 3;
                                break;
                            }
                            case 'D': {
                                type = 2;
                                break;
                            }
                            case 'C': {
                                type = 1;
                                break;
                            }
                        }
                        result += power * type;

                    }

                }


            }
            if (!values.containsKey(name)) {
                values.put(name, result);
            }else {
                values.put(name, values.get(name) + result);
            }
            list.removeAll(list);
            result = 0;


            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            System.out.printf("%s: %d\n",entry.getKey(),entry.getValue());
        }

    }
}
