package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String cases = tokens[0];
            switch (cases) {
                case "1": {
                    int number = Integer.parseInt(tokens[1]);
                    stack.push(number);
                    break;
                }
                case "2": {
                    stack.pop();
                    break;
                }
                case "3": {
                    int max = Integer.MIN_VALUE;
                        for (Integer integer : stack) {
                            if (integer > max) {
                                max = integer;
                            }
                    }
                    System.out.println(max);
                    break;
                }
            }
        }
    }
}
