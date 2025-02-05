package csc223.tv;

import java.util.Scanner;

public class TicTacToe implements Game {

    //declaration 

    char[][] board;
    char[] players = {'X', 'O'};
    int currentPlayers;
    boolean gameOver;

    //this is the constructor
    public TicTacToe() {
        board = new char[3][3];
        for (int i =0; i < 3; i++){
            for (int j = 0; j < 3; j ++){
                board[i][j] = ' ';
            }
        }
        currentPlayers = 0;
        gameOver = false;
    }
    
    public void startGame(){
        System.out.println("Welcome to TicTacToe");

    }
    
    //print out the board for the game 
    public void printBoard(){
        System.out.println("  A   B   C");
        for (int i =0; i < 3; i++){
            System.out.print(i + " ");
            for (int j =0; j < 3; j++){
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  --+---+--");
            }
        }
    }


    public void takeTurn(){
        Scanner scanner = new Scanner(System.in);
        // loop the game until there is one person win or draw
        while (true){
            System.out.println("Player " + players[currentPlayers] + "'s turn");
            System.out.println("Enter place (Ex A0): ");
            String move = scanner.nextLine().trim().toUpperCase(); // turn the thing that user input into upper case
            // get the coordinates 
            int[] coordinates = getCoordinates(move);

            // check if the square the players want to go is a valid place
            if (coordinates != null && board[coordinates[0]][coordinates[1]] == ' ') {
                // fill the board at the coordinates with the symbol of the player of that turn
                board[coordinates[0]][coordinates[1]] = players[currentPlayers];
                break; // break and turn to the other player if the move is a valid move
            } else {
                System.out.println("Ivalid Move. Enter again");
            }
            printBoard();
        }

    }

    // check the game is over or not
    public boolean isGameOver() {
        if (checkWin(players[currentPlayers])) {
            printBoard();
            System.out.println("Player " + players[currentPlayers] + " wins");
            gameOver = true;
        }else if (checkDraw(board)){
            printBoard();
            System.out.println("It's a draw");
            gameOver = true;
        }
        return gameOver;

    }   

    // This function is to end the game
    public void endGame(){
        System.out.println("Game over!");
    }

    // The main loop of the game is here
    public void playGame(){
        startGame();
        while (!gameOver) {
            printBoard();
            takeTurn();
            if (isGameOver()){
                break;
            }
            currentPlayers = 1 - currentPlayers; //switch the players after each turn
            
        }
        endGame();
    }

    // This function is to get the coordinate from the move that we enter through key board
    private int[] getCoordinates(String move){
        // if the move is not equal to the return nothing
        if (move.length() != 2) {
            return null;
        }

        //* assign var to store the value of each coordinates because each coordinate have to part the string part and the number part */
        int column = move.charAt(0) - 'A';
        int row = move.charAt(1) - '0';

        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            return null;
        }

        // return the coordinates and store them in the arrays
        return new int[] {row, column};
        

    }

    // check if any player win the game
    private boolean checkWin(char player){
        // check the row and column
        for (int i = 0; i < 3; i++){
            
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player || board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // check the diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player || board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        
        return false;
    }

    // if there is a square that empty then it's not a draw
    private boolean checkDraw(char[][] board) {
        for (int i =0; i < 3; i++){
            for (int j =0 ; j < 3; j++){
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return !checkWin(players[0]) && !checkWin(players[1]);
    }

    public static void main(String[] args){
        new TicTacToe().playGame();

    }
    
}
