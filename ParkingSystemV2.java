package MultidimensionalArrays;

import java.util.Scanner;

public class ParkingSystemV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] matrixSize = sc.nextLine().split(" ");
        int[][] matrix = new int[Integer.parseInt(matrixSize[0])][Integer.parseInt(matrixSize[1])];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }
        while (true) {
            String input = sc.nextLine();
            if (input.equals("stop")) {
                break;
            }
            String[] inputSplit = input.split(" ");
            int z = Integer.parseInt(inputSplit[0]);
            int row = Integer.parseInt(inputSplit[1]);
            int col = Integer.parseInt(inputSplit[2]);
            int distance = 0;
            int tempCol = col;
            boolean hasParked = false;
            while (matrix[row][tempCol] == 1) {
                if (tempCol >= 1) {
                    tempCol--;
                } else {
                    tempCol = col;
                    break;
                }
            }
            col = tempCol;
            if (z <= row) {
                for (int i = z; i <= row; i++) {
                    if (i == row) {
                        for (int j = 0; j < matrix[0].length; j++) {
                            if (hasParked) {
                                break;
                            }
                            if (j == col) {
                                if (matrix[row][j] == 0) {
                                    distance++;
                                    hasParked = true;
                                    matrix[row][col] = 1;
                                    System.out.println(distance);
                                    break;
                                } else {
                                    while (matrix[row][j] != 0) {
                                        if (j == matrix[0].length - 1) {
                                            break;
                                        }
                                        distance++;
                                        j++;
                                    }
                                    if (j == matrix[0].length - 1 && matrix[row][j] == 1) {
                                        System.out.printf("Row %d full\n", row);
                                        break;
                                    }
                                    distance++;
                                    matrix[row][j] = 1;
                                    hasParked = true;
                                    System.out.println(distance);
                                }
                            }
                            distance++;
                        }
                    }
                    if (hasParked) {
                        break;
                    }
                    distance++;
                }
            } else {
                for (int i = z; i >= 0; i--) {
                    if (i == row) {
                        for (int j = 0; j < matrix[0].length; j++) {
                            if (hasParked) {
                                break;
                            }
                            if (j == col) {
                                if (matrix[row][j] == 0) {
                                    distance++;
                                    hasParked = true;
                                    matrix[row][col] = 1;
                                    System.out.println(distance);
                                    break;
                                } else {
                                    while (matrix[row][j] != 0) {
                                        if (j == matrix[0].length - 1) {
                                            break;
                                        }
                                        distance++;
                                        j++;
                                    }
                                    if (j == matrix[0].length - 1 && matrix[row][j] == 1) {
                                        System.out.printf("Row %d full\n", row);
                                        break;
                                    }
                                    distance++;
                                    matrix[row][j] = 1;
                                    hasParked = true;
                                    System.out.println(distance);
                                }
                            }
                            distance++;
                        }
                    }
                    if (hasParked) {
                        break;
                    }
                    distance++;
                }
            }
        }
    }
}
