package Sets;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            String[] cmdParts = command.split(", ");
            String direction = cmdParts[0];
            String carNumber = cmdParts[1];
            switch (direction) {
                case "IN": {
                    parkingLot.add(carNumber);
                    break;
                }
                case "OUT": {
                    parkingLot.remove(carNumber);
                    break;
                }
            }

            command = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }else {
            for (String s : parkingLot) {
                System.out.println(s);
            }

        }
    }
}
