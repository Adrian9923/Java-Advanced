package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int[][] matrix = new int[rows][rows];
        String pattern = input[1];
        int startingNumber = 1;
        if (pattern.equals("A")) {
            fillPatternA(rows,matrix, startingNumber);
        }
        else if (pattern.equals("B")) {
            fillPatternB(rows, matrix, startingNumber);
        }


    }


    private static void fillPatternA(int size , int[][] matrix, int startingNumber) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = startingNumber;
                startingNumber += size;
            }
            startingNumber = 2;
            startingNumber += i;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void fillPatternB(int size, int[][] matrix, int startingNumber) {
        for (int i = 0; i < matrix.length; i++) {

                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = startingNumber;
                    startingNumber += 1;
                }

        }



        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}