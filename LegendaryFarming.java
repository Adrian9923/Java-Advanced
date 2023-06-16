package ExamPreparation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        boolean isItemObtained = false;

        Map<String, Integer> junkMaterials = new TreeMap<>();
        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);

        while (!isItemObtained) {
            String input = bfr.readLine().toLowerCase();
            String[] tokens = input.split("\\s+");

            List<String> materialsList = new ArrayList<>();
            List<Integer> quantityList = new ArrayList<>();

            for (int i = 0; i < tokens.length; i++) {
                if (i % 2 == 0) {
                    quantityList.add(Integer.parseInt(tokens[i]));
                } else {
                    materialsList.add(tokens[i]);
                }
            }

            for (int i = 0; i < materialsList.size(); i++) {
                if (keyMaterials.containsKey(materialsList.get(i))) {
                    keyMaterials.put(materialsList.get(i), keyMaterials.get(materialsList.get(i)) + quantityList.get(i));
                    for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
                        if (entry.getKey().equals("shards") && entry.getValue() >= 250) {
                            System.out.println("Shadowmourne obtained!");
                            keyMaterials.put("shards", keyMaterials.get("shards") - 250);
                            isItemObtained = true;
                            break;
                        } else if (entry.getKey().equals("fragments") && entry.getValue() >= 250) {
                            System.out.println("Valanyr obtained!");
                            keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
                            isItemObtained = true;
                            break;
                        } else if (entry.getKey().equals("motes") && entry.getValue() >= 250) {
                            System.out.println("Dragonwrath obtained!");
                            keyMaterials.put("motes", keyMaterials.get("motes") - 250);
                            isItemObtained = true;
                            break;
                        }
                    }
                    if (isItemObtained) {
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
                    int firstComparison = s.getValue().compareTo(f.getValue());
                    if (firstComparison == 0) {
                        return f.getKey().compareTo(s.getKey());
                    }
                    return firstComparison;
                })
                .forEach(e -> System.out.printf("%s: %d\n",e.getKey(),e.getValue()));

        junkMaterials.entrySet()
                .forEach(e -> System.out.printf("%s: %d\n",e.getKey(),e.getValue()));
    }
}