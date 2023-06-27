package HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounterV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> countriesAndTotalPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Long>> citiesAndTheirPopulation = new LinkedHashMap<>();

        String command;

        while (!"report".equals(command = reader.readLine())) {
            String[] inputData = command.split("\\|");

            String city = inputData[0];
            String country = inputData[1];
            long population = Long.parseLong(inputData[2]);

            if (!countriesAndTotalPopulation.containsKey(country)) {
                countriesAndTotalPopulation.put(country, population);
            } else {
                countriesAndTotalPopulation.put(country, countriesAndTotalPopulation.get(country) + population);
            }

            if (!citiesAndTheirPopulation.containsKey(country)) {
                citiesAndTheirPopulation.put(country, new LinkedHashMap<>());
                citiesAndTheirPopulation.get(country).put(city, population);
            } else {
                citiesAndTheirPopulation.get(country).put(city, population);
            }
        }

        countriesAndTotalPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .forEach(currentCountry -> {
                    System.out.printf("%s (total population: %d)%n",
                            currentCountry.getKey(), currentCountry.getValue());

                    citiesAndTheirPopulation.get(currentCountry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue()
                                    .reversed())
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
