import java.util.Random;

public class TicTacToe2 {

    static char[][] board = new char[3][3];

    // 🔹 Game State Variables (UC2)
    static char playerSymbol;
    static char computerSymbol;
    static char currentTurn;

    public static void main(String[] args) {

        initializeBoard();   // UC1
        printBoard();        // UC1

        toss();              // UC2
    }

    // 🔹 UC1: Initialize board
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // 🔹 UC1: Display board
    static void printBoard() {
        System.out.println("\nEmpty Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 🔹 UC2: Toss logic
    static void toss() {
        Random random = new Random();

        int tossResult = random.nextInt(2); // 0 or 1

        if (tossResult == 0) {
            System.out.println("\nToss Result: Player starts first");

            playerSymbol = 'X';
            computerSymbol = 'O';
            currentTurn = playerSymbol;

        } else {
            System.out.println("\nToss Result: Computer starts first");

            playerSymbol = 'O';
            computerSymbol = 'X';
            currentTurn = computerSymbol;
        }

        // Display assignments
        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentTurn);
    }
}