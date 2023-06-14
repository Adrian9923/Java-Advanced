package Exam;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> countriesAndCities = new LinkedHashMap<>();
        Map<String, Integer> citiesAndPopulation = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("report")) {
            String[] cmdParts = command.split("\\|");
            String city = cmdParts[0];
            String country = cmdParts[1];
            int population = Integer.parseInt(cmdParts[2]);

            if (!countriesAndCities.containsKey(country)) {
                countriesAndCities.put(country, new ArrayList<>());
                countriesAndCities.get(country).add(city);
            }else {
                countriesAndCities.get(country).add(city);
            }

            if (!citiesAndPopulation.containsKey(city)) {
                citiesAndPopulation.put(city, population);
            }else {
                citiesAndPopulation.put(city, citiesAndPopulation.get(city) + population);
            }


            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : countriesAndCities.entrySet()) {
            System.out.printf("%s\n",entry.getKey());
            for (Map.Entry<String, Integer> entry2 : citiesAndPopulation.entrySet()) {
                if (entry.getValue().equals(entry2.getKey())) {
                    System.out.printf("=>%s: %d\n",entry2.getKey(), entry2.getValue());
                }
            }

        }

    }
}
