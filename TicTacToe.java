import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        initializeBoard();   // UC1: Initialization
        printBoard();        // UC1: Display empty board

        while (true) {
            playerMove();
            printBoard();
            if (checkWin('X')) {
                System.out.println("You win!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            computerMove();
            printBoard();
            if (checkWin('O')) {
                System.out.println("Computer wins!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    // 🔹 UC1: Initialize board with '-'
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {            // Outer loop (rows)
            for (int j = 0; j < 3; j++) {        // Inner loop (columns)
                board[i][j] = '-';
            }
        }
    }

    // 🔹 UC1: Print board in readable format
    static void printBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 🔹 Player Move
    static void playerMove() {
        int row, col;

        while (true) {
            System.out.print("Enter row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = 'X';
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    // 🔹 Computer Move (Random)
    static void computerMove() {
        int row, col;

        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);

            if (board[row][col] == '-') {
                board[row][col] = 'O';
                System.out.println("Computer placed at: " + row + ", " + col);
                break;
            }
        }
    }

    // 🔹 Check Win
    static boolean checkWin(char symbol) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol)
                return true;
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol)
                return true;
        }

        // Diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol)
            return true;

        return false;
    }

    // 🔹 Check if board is full
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}