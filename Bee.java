package Exam;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        boolean isOut = false;
        int playerRow = 0;
        int playerCol = 0;

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrix.length; row++) {
            char[] elements = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (elements[col] == 'B') {
                    playerRow = row;
                    playerCol = col;
                }
                matrix[row][col] = elements[col];
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End") || isOut){
            matrix[playerRow][playerCol] = '.';

            switch (command) {
                case "up":
                    if (!isInRange(playerRow - 1, playerCol, matrix)) {
                        isOut = true;
                        System.out.println("The bee got lost!");
                        break;
                    }else {
                        playerRow--;
                    }
                    if (isFlower(playerRow,playerCol,matrix)){
                        counter++;
                    }
                    if (isBonus(playerRow,playerCol,matrix)) {
                        if (!isInRange(playerRow - 1, playerCol, matrix)) {
                            isOut = true;
                            System.out.println("The bee got lost!");
                            break;
                        }else {
                            playerRow--;
                            matrix[playerRow + 1][playerCol] = '.';
                        }
                    }
                    matrix[playerRow][playerCol] = 'B';
                    break;
                case "down":
                    if (!isInRange(playerRow + 1, playerCol, matrix)) {
                        isOut = true;
                        System.out.println("The bee got lost!");
                        break;
                    }else {
                        playerRow++;
                    }
                    if (isFlower(playerRow,playerCol,matrix)){
                        counter++;
                    }
                    if (isBonus(playerRow,playerCol,matrix)) {
                        if (!isInRange(playerRow + 1, playerCol, matrix)) {
                            isOut = true;
                            System.out.println("The bee got lost!");
                            break;
                        }else {
                            playerRow++;
                            matrix[playerRow - 1][playerCol] = '.';
                        }
                    }
                    matrix[playerRow][playerCol] = 'B';
                    break;
                case "left":
                    if (!isInRange(playerRow, playerCol - 1, matrix)) {
                        isOut = true;
                        System.out.println("The bee got lost!");
                        break;
                    }else {
                        playerCol--;
                    }
                    if (isFlower(playerRow,playerCol,matrix)){
                        counter++;
                    }
                    if (isBonus(playerRow,playerCol,matrix)) {
                        if (!isInRange(playerRow, playerCol - 1, matrix)) {
                            isOut = true;
                            System.out.println("The bee got lost!");
                            break;
                        }else {
                            playerCol--;
                            matrix[playerRow][playerCol + 1] = '.';
                        }
                    }
                    matrix[playerRow][playerCol] = 'B';
                    break;
                case "right":
                    if (!isInRange(playerRow, playerCol + 1, matrix)) {
                        isOut = true;
                        System.out.println("The bee got lost!");
                        break;
                    }else {
                        playerCol++;
                    }
                    if (isFlower(playerRow,playerCol,matrix)){
                        counter++;
                    }
                    if (isBonus(playerRow,playerCol,matrix)) {
                        if (!isInRange(playerRow, playerCol + 1, matrix)) {
                            isOut = true;
                            System.out.println("The bee got lost!");
                            break;
                        }else {
                            playerCol++;
                            matrix[playerRow][playerCol - 1] = '.';
                        }
                    }
                    matrix[playerRow][playerCol] = 'B';
                    break;

            }
            if (isOut) {
                break;
            }


            command = scanner.nextLine();
        }
        if (counter >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n",counter + 1);
            printMatrix(matrix);
        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n",(5 - counter));
            printMatrix(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isBonus(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'O';
    }

    private static boolean isFlower(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'f';
    }

    private static boolean isInRange(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[playerRow].length;
    }
}
