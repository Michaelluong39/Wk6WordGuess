package com.company.views;

import java.util.List;
import java.util.Scanner;

public class CmdLineView {

    private String[] letters;
    private String theGuess;

    public CmdLineView(String[] letters) {
        this.letters = letters;
    }

    public void startGames() {
        System.out.println("Guess the word:\n");
        for(int i = 0; i < letters.length; i++){
            System.out.print("_ ");
        }
        System.out.println("\n");
    }

    public String makeAGuess(int numGuesses){
        System.out.println("Guess a letter: (" + numGuesses + " more tries)\n");
        Scanner input = new Scanner(System.in);

        return input.next();
    }

    public static boolean displayAnswer(List<Character> guessMade, String theWord, String[] letters) {
        int correct = 0;
        for (int i = 0; i < letters.length; i++){
            if(guessMade.contains(theWord.charAt(i))){
                System.out.print(theWord.charAt(i));
                correct++;
            }
            else{
                System.out.print("_");
            }

        }
        System.out.println();
        return (theWord.length() == correct);
    }


    public void displayHints(String[] hints){
        for(String hint: hints){
            System.out.print(hint);

        }
        System.out.print("\n");
    }

    public void winner() {
        System.out.println("Winner Winner, Chicken Dinner!");
    }

    public void tryAgain(String theWord) {
        System.out.print("The word was " + theWord + ", try again next time.");
    }

    public void cheat(String theWord){
        System.out.print("The word is " + theWord + ".\n");
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }
}
