import java.util.Random;
import java.util.Scanner;

public class TicTacToe3 {

    static char[][] board = new char[3][3];

    static char playerSymbol;
    static char computerSymbol;
    static char currentTurn;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initializeBoard();   // UC1
        printBoard();        // UC1

        toss();              // UC2

        playerMove();        // UC4 demo
        printBoard();
    }

    // UC1: Initialize board
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // UC1: Display board
    static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC2: Toss
    static void toss() {
        Random random = new Random();
        int tossResult = random.nextInt(2);

        if (tossResult == 0) {
            System.out.println("\nPlayer starts first");
            playerSymbol = 'X';
            computerSymbol = 'O';
            currentTurn = playerSymbol;
        } else {
            System.out.println("\nComputer starts first");
            playerSymbol = 'O';
            computerSymbol = 'X';
            currentTurn = computerSymbol;
        }

        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }

    // UC4: Convert slot → row, col and place move
    static void playerMove() {
        int slot;

        while (true) {
            System.out.print("\nEnter slot (1-9): ");
            slot = scanner.nextInt();

            if (slot < 1 || slot > 9) {
                System.out.println("Invalid slot! Choose between 1-9.");
                continue;
            }

            // UC4 CORE LOGIC
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (board[row][col] == '-') {
                board[row][col] = playerSymbol;
                break;
            } else {
                System.out.println("Slot already taken! Try again.");
            }
        }
    }
}