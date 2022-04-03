package de.magicmarcy.guessthenumber;

import javax.swing.JOptionPane;

/**
 * Just a simple GuessTheNumber-Game. Picks a random number and lets you guess which number it is ;-)
 *
 * @author magicmarcy | 03.04.2022
 */
public class GuessTheNumberGame {

  public static void main(final String[] args) {

    int randomNumber = (int) (Math.random() * 100 + 1);
    int userAnswer = 0;

    // DEV-Cheat: Shows the random number in the console!
    System.out.println("The correct guess would be " + randomNumber);

    int answerCount = 1;

    while (userAnswer != randomNumber) {
      final String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 and 100", "GuessingTheNumber-Game", JOptionPane.QUESTION_MESSAGE);

      userAnswer = Integer.parseInt(response);

      JOptionPane.showMessageDialog(null, "" + determineGuess(userAnswer, randomNumber, answerCount));

      answerCount++;
    }
  }

  public static String determineGuess(final int userAnswer, final int randomNumber, final int answerCount) {
    if (userAnswer <= 0 || userAnswer > 100) {
      return "Your guess is invalid";
    } else if (userAnswer == randomNumber ) {
      return "Correct!\nTotal Guesses: " + answerCount;
    } else if (userAnswer > randomNumber) {
      return "Your guess is too high, try again.\nTry #" + answerCount;
    } else if (userAnswer < randomNumber) {
      return "Your guess is too low, try again.\nTry #" + answerCount;
    } else {
      return "Your guess is incorrect\nTry #" + answerCount;
    }
  }
}
