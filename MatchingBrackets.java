package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String command = scanner.nextLine();
        for (int i = 0; i < command.length(); i++) {
            char character = command.charAt(i);
            if (character == '('){
                stack.push(i);
            }
            if (character == ')') {
                int endIndex = i + 1;
                int startIndex = stack.pop();
                String subExp = command.substring(startIndex, endIndex);
                System.out.println(subExp);
            }
        }
    }
}
