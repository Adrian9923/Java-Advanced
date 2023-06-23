package HomeWork;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Map<String, TreeMap<String, int[]>> data = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            int damage = 0;
            int health = 0;
            int armor = 0;

            damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            if (!data.containsKey(type)) {
                data.put(type, new TreeMap<>());
            }

            if (!data.get(type).containsKey(name)) {
                data.get(type).put(name, new int[3]);
            }

            data.get(type).get(name)[0] = damage;
            data.get(type).get(name)[1] = health;
            data.get(type).get(name)[2] = armor;
        }

        for (Map.Entry<String, TreeMap<String, int[]>> outerEntry : data.entrySet()) {
            String type = outerEntry.getKey();
            TreeMap<String, int[]> innerMap = outerEntry.getValue();

            double avgDamage = innerMap.values().stream().mapToInt(a -> a[0]).average().orElse(0.0);
            double avgHealth = innerMap.values().stream().mapToInt(a -> a[1]).average().orElse(0.0);
            double avgArmor = innerMap.values().stream().mapToInt(a -> a[2]).average().orElse(0.0);

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, int[]> innerEntry : innerMap.entrySet()) {
                String name = innerEntry.getKey();
                int[] stats = innerEntry.getValue();

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name, stats[0], stats[1], stats[2]);
            }
        }
    }
}

