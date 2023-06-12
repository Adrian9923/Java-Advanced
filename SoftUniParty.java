package Sets;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> reservationList = new TreeSet<>();
        Set<String> listWithPersonsWhoCame = new TreeSet<>();

        String command = scanner.nextLine();

        while (!command.equals("PARTY")) {

            reservationList.add(command);

            command = scanner.nextLine();
        }

        String command2 = scanner.nextLine();

        while (!command2.equals("END")) {

            listWithPersonsWhoCame.add(command2);

            command2 = scanner.nextLine();
        }

        for (String s : listWithPersonsWhoCame) {
            if (reservationList.contains(s)) {
                reservationList.remove(s);
            }
        }
        System.out.printf("%d\n", reservationList.size());
        for (String s : reservationList) {
            System.out.println(s);
        }


    }
}
