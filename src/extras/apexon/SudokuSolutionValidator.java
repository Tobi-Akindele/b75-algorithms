package extras.apexon;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolutionValidator {

    public static boolean validate(int[][] board) {

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col +=3) {
                if (!isValidBlock(board, row, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidBlock(int[][] board, int startRow, int startCol) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = board[startRow + i][startCol + j];
                if (value == 0 || value > 9 || !seen.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        int[][] board2 = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 0, 3, 4, 8},
                {1, 0, 0, 3, 4, 2, 5, 6, 0},
                {8, 5, 9, 7, 6, 1, 0, 2, 0},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 0, 1, 5, 3, 7, 2, 1, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 0, 0, 4, 8, 1, 1, 7, 9}
        };

        int[][] board3 = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 10, 7, 9}
        };

        System.out.println(validate(board));
        System.out.println(validate(board2));
        System.out.println(validate(board3));
    }

    public static void printSubGrid(int[][] board, int startRow, int startCol) {
        System.out.println("Subgrid starting at (" + (startRow / 3) + "," + (startCol / 3) + "):");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[startRow + i][startCol + j] + " ");
            }
            System.out.println(); // new line after each row
        }
    }
}
