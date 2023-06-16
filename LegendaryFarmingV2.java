package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarmingV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        boolean isObtained = false;

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (!isObtained) {
            String[] tokens = bfr.readLine().toLowerCase().split("\\s+");

            List<String> materialsList = new ArrayList<>();
            List<Integer> quantityList = new ArrayList<>();

            for (int i = 0; i < tokens.length; i++) {
                if (i % 2 == 0) {
                    quantityList.add(Integer.parseInt(tokens[i]));
                }else {
                    materialsList.add(tokens[i]);
                }
            }

            for (int i = 0; i < materialsList.size(); i++) {
                if (keyMaterials.containsKey(materialsList.get(i))) {
                    keyMaterials.put(materialsList.get(i), keyMaterials.get(materialsList.get(i)) + quantityList.get(i));
                    for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
                        if (entry.getKey().equals("shards") && entry.getValue() >= 250){
                            System.out.println("Shadowmourne obtained!");
                            keyMaterials.put(entry.getKey(), keyMaterials.get(entry.getKey()) - 250);
                            isObtained = true;
                            break;
                        }else if (entry.getKey().equals("fragments") && entry.getValue() >= 250){
                            System.out.println("Valanyr obtained!");
                            keyMaterials.put(entry.getKey(), keyMaterials.get(entry.getKey()) - 250);
                            isObtained = true;
                            break;
                        }else if (entry.getKey().equals("motes") && entry.getValue() >= 250) {
                            System.out.println("Dragonwrath obtained!");
                            keyMaterials.put(entry.getKey(), keyMaterials.get(entry.getKey()) - 250);
                            isObtained = true;
                            break;
                        }
                    }

                    if (isObtained) {
                        break;
                    }
                }else {
                    if (junkMaterials.containsKey(materialsList.get(i))) {
                        junkMaterials.put(materialsList.get(i), junkMaterials.get(materialsList.get(i)) + quantityList.get(i));
                    }else {
                        junkMaterials.put(materialsList.get(i), quantityList.get(i));
                    }
                }
            }

        }
        keyMaterials.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int comparison = s.getValue().compareTo(f.getValue());
                    if (comparison == 0) {
                        return f.getKey().compareTo(s.getKey());
                    }
                    return comparison;
                })
                .forEach(e -> System.out.printf("%s: %d\n",e.getKey(), e.getValue()));

        junkMaterials.entrySet()
                .forEach(e -> System.out.printf("%s: %d\n",e.getKey(), e.getValue()));
    }
}
