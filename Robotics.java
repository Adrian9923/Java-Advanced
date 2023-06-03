package StacksAndQueues;

import java.util.*;

public class Robotics {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] data = scan.nextLine().split(";");

        Map<String, Integer> robots = new LinkedHashMap<>();
        Map<String, Boolean> freeRobots = new HashMap<>();
        Map<String, Integer> cooldown = new HashMap<>();

        String[] robotData = new String[2];
        for (int i = 0; i < data.length; i++) {
            robotData[0] = data[i].split("-")[0];
            robotData[1] = data[i].split("-")[1];
            robots.put(robotData[0], Integer.parseInt(robotData[1]));
            freeRobots.put(robotData[0], true);
            cooldown.put(robotData[0], 0);
        }

        String[] time = scan.nextLine().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        String material = scan.nextLine();

        while (!material.equals("End")) {
            queue.offer(material);
            material = scan.nextLine();
        }

        while (queue.size() > 0) {
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
                if (minutes == 60) {
                    hours++;
                    minutes = 0;
                    if (hours == 24){
                        hours = 0;
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : robots.entrySet()) {

                if (freeRobots.get(entry.getKey()) == false) {
                    cooldown.put(entry.getKey(), cooldown.get(entry.getKey()) - 1);
                    if (cooldown.get(entry.getKey()) == 0) {
                        freeRobots.put(entry.getKey(), true);
                    }
                }
            }

            boolean anyone = false;

            for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                if (freeRobots.get(entry.getKey()) == true) {
                    freeRobots.put(entry.getKey(), false);
                    cooldown.put(entry.getKey(), entry.getValue());
                    System.out.print(entry.getKey() + " - " + queue.poll() + " [");

                    if (hours < 10) {
                        System.out.print("0");
                    }
                    System.out.print(hours + ":");
                    if (minutes < 10) {
                        System.out.print("0");
                    }
                    System.out.print(minutes + ":");
                    if (seconds < 10) {
                        System.out.print("0");
                    }
                    System.out.println(seconds + "]");
                    anyone = true;
                    break;
                }
            }

            if (anyone == false) {
                queue.offer(queue.poll());
            }
        }
    }
}
