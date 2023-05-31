package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] elements = scanner.nextLine().split(" ");
        int n = Integer.parseInt(elements[0]);
        int s = Integer.parseInt(elements[1]);
        int x = Integer.parseInt(elements[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)){
            System.out.println(true);
        }else if (stack.isEmpty()){
            System.out.println("0");
        }
        else {
            int min = calcMin(stack);
            System.out.println(min);
        }

    }
    public static int calcMin(ArrayDeque<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min)
                min = number;
        }
        return min;
    }
}
