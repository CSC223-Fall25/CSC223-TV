package csc223.tv;
import java.util.Scanner;

public class WordGuess implements Game {
    // Declare variables
    String word;
    StringBuilder guessed;
    int chances;
    // use scanner to read input
    Scanner scanner = new Scanner(System.in);
    // this fuction store the list of word that will be used during the game
    private String pickRandomWord(){
        String[] words = {"pride", "bride", "house", "nvidia", "apple", "machine"};
        return words[(int) (Math.random() * words.length)];
    }
    // Start the game with an empty word
    public void startGame(){
        word = pickRandomWord();
        guessed = new StringBuilder("_".repeat(word.length()));
        chances = 10;
        System.out.println("Welcome to Word Guess");
    }
    //Print out the chances player have left 
    public void printBoard(){
        System.out.println("Guess the letter or the Entire Word: " + guessed);
        System.out.println("You have " + chances + " chances remaining");
    }
    //Let the player guessing the word turn by turn
    public void takeTurn(){
        System.out.println("Enter your guess ");
        String guess = scanner.next().toLowerCase();
        // if the player guess one charater at a time
        if (guess.length() == 1) {
            char letter = guess.charAt(0);
            if (word.contains(String.valueOf(letter))){
                
                for (int i = 0; i < word.length(); i++){
                    if (word.charAt(i) == letter){
                        guessed.setCharAt(i, letter);
                    }
                }
            } else {
                System.out.println(letter + " is not in the word");
                chances -= 1;
            }
        // if the character guess the whole word
        } else if (guess.equals(word)){
            guessed = new StringBuilder(word);
        } else {
            System.out.println("Wrong Guess!");
            chances -= 1;
        }
    }
    // check if the chances is equal to zero or not and check if the word has been guessed correctly
    public boolean isGameOver(){
        return chances == 0 || guessed.toString().equals(word);
    }
    // End game when the user guessed the word or ran out of chances
    public void endGame(){
        if (guessed.toString().equals(word)){ 
            System.out.println("Congrats! Your guess was correct, the word was " + word);

        } else {
            System.out.println("Sorry, your guesses were wrong, the word was " + word);
        }
        System.out.println("Do you wanna play (yes/ no):");
        String playAgain = scanner.next().toLowerCase();
        if (playAgain.equals("yes") || playAgain.equals("y")){
            playGame();
        } else {
            System.out.println("Thanks for playing");
        }

    }
    
    public void playGame(){
        startGame();
        while (!isGameOver()){
            printBoard();;
            takeTurn();
        }
        endGame();
    }

    public static void main(String[] args){
        new WordGuess().playGame();
    }
}
