import java.util.*;

public class ticTacToe {

    //Declare international variables
    private static final int ROW = 3;

    private static final int COL = 3;

    private static String board [][] = new String[ROW][COL];

    private static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Variables
        String playerMove = "x";

        boolean done = false;

        boolean gameOver = false;

        //Loop
        do {

            //Clear the board
            clearBoard();

            //Display the board
            display();

            //Loop
            do {

                //Say which player is going
                System.out.println("Player " + playerMove + " is going");

                //Collect the row move
                int rowMove = SafeInput.getRangedInt(in, "Enter the row position", 1, 3);

                //Collect the column move
                int colMove = SafeInput.getRangedInt(in, "Enter the column position", 1, 3);

                //Make moves work with array
                rowMove --;
                colMove --;

                //Put move on board
                board[rowMove][colMove] = playerMove;




            } while (!gameOver);

            //Play again?
            done = SafeInput.getYNConfirm(in, "Would you like to play again?");

        } while (!done);

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

        }

    }


}
