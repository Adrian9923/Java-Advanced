package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class ReverseNumberWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i : arr) {
            stack.push(i);
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }

    }
}
