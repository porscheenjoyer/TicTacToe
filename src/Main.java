import java.util.Scanner;

public class Main {

    private static final int ROW = 3;

    private static final int COL = 3;

    private static final String[][] board = new String[ROW][COL];


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Variables
        String playerMove = "x";

        boolean done = true;

        boolean gameOver = false;

        boolean validMove;

        int moveCount = 0;

        //Loop
        do {

            //Clear the board
            clearBoard();

            //Replay loop
            do {

                    //Display the board
                    display();

                    //Say which player is going
                    System.out.println("Player " + playerMove + " is going");

                    //Move loop
                    do {

                        //Collect the row move
                        int rowMove = SafeInput.getRangedInt(in, "Enter the row position", 1, 3);

                        //Collect the column move
                        int colMove = SafeInput.getRangedInt(in, "Enter the column position", 1, 3);

                        //Make moves work with array
                        rowMove --;
                        colMove --;

                        //Check for a valid input
                        validMove = isValidMove(rowMove, colMove);

                        if (validMove) {

                            //Put move on board
                            board[rowMove][colMove] = playerMove;

                            //Add move count for tie
                            moveCount ++;

                            //Exit move loop
                            break;

                        }

                        else {

                            System.out.println("There is already something there :)");

                        }

                    } while (true);

                    //Check for win
                    if (isWin(playerMove)) {

                        gameOver = true;

                    }

                    //toggle player move
                    if (playerMove.equals("x")) {

                        playerMove = "o";

                    }

                    else {

                        playerMove = "x";

                    }

                    //Check for tie
                    if (moveCount == 9 && !gameOver) {

                        gameOver = true;
                        System.out.println("Tie!");

                    }

            } while(!gameOver);

            //Play again?
            done = SafeInput.getYNConfirm(in, "Would you like to play again(y or n)?");

        } while (done);

    }

    //Clear the board
    private static void clearBoard() {

        //Loop
        for (int row = 0; row < ROW; row ++) {

            //Loop
            for (int col = 0; col < COL; col ++) {

                board[row][col] = "-";

            }

        }

    }

    //display the board
    private static void display() {

        //Loop
        for (int row = 0; row < ROW; row ++) {

            System.out.print("| ");

            //Loop
            for (int col = 0; col < COL; col ++) {

                System.out.print(board[row][col] + " | ");

            }
            System.out.println();

        }

    }

    private static boolean isValidMove (int row, int col) {

        boolean validMove = board[row][col].equals("-");

        return validMove;

    }

    private static boolean isWin(String player) {

        boolean win = false;

        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {

            win = true;

        }

        System.out.println("Win " + win);

        return win;

    }

    private static boolean isColWin(String player) {

        boolean colWin = false;

        for (int i = 0; i < 3; i ++) {

            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {

                colWin = true;
                System.out.println("You won!");

            }

        }

        System.out.println("Column " + colWin);

        return colWin;

    }

    private static boolean isRowWin(String player) {

        boolean rowWin = false;

        for (int i = 0; i < 3; i ++) {

            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {

                rowWin = true;
                System.out.println("You won!");

            }

        }

        System.out.println("Row " + rowWin);

        return rowWin;

    }

    private static boolean isDiagonalWin(String player) {

        boolean diagWin = false;

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {

            diagWin = true;
            System.out.println("You won!");

        }

        else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {

            diagWin = true;
            System.out.println("You won!");

        }

        System.out.println("Diagonal " + diagWin);

        return diagWin;

    }

}