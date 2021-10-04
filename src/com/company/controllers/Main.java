package com.company.controllers;

import com.company.models.WordList;
import com.company.views.CmdLineView;
import java.util.ArrayList;
import java.util.List;

import static com.company.views.CmdLineView.displayAnswer;


public class Main {

    public static String[] letters;
    public static int numLetters = 0;
    public static int numGuesses;
    public static String theGuess;
    public static String[] hints;
    public static CmdLineView view;

    public static void main(String[] args) {
        List<Character> guessMade = new ArrayList<>(); //stores characters in list of arrays
        numGuesses = 6; //set number of guesses

        GetWord getWord = new GetWord();
        String theWord = getWord.getTheWord();
        // System.out.println(theWord);

        WordList word = new WordList(theWord);

        letters = calculateLetters(word.getTheWord());

        view = new CmdLineView(letters);
        view.startGames();
        //view.cheat(word.getTheWord());

        while(numGuesses > 0){

            hints = guess();
            guessMade.add(theGuess.charAt(0)); //stores only 1st(0) character

            if(displayAnswer(guessMade, theWord, letters)){
                view.winner();
            break;
            }

            if(numGuesses == 0){
                view.tryAgain(theWord);
            }


            //view.displayHints(hints);

            //System.out.print(guessMade); //display stored list
            }


    }


    private static String[] calculateLetters(String theWord){
        String[] letters = theWord.split("");
        numLetters = letters.length;
        return letters;
    }

    private static String[] guess(){
        // take the guess from the user
        theGuess = view.makeAGuess(numGuesses);

        String msg = "";

        String[] hints = new String[letters.length];

        boolean guessCorrect = false; //true false statement to reduce guesses

        for(int i = 0; i < letters.length; i++){
            if(letters[i].equals(theGuess)){
                hints[i] = theGuess;
                guessCorrect = true;
            }
            else {
                hints[i] = "_";
            }
        }
        if(!guessCorrect){
            numGuesses--;
        }

        return hints;
    }

}
