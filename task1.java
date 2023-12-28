import java.util.Random;
import java.util.Scanner;

public class task1
{
    public static void main(String[] args) 
   {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 3;
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        do
	 {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nNew round! Guess the number between " + lowerBound + " and " + upperBound);

            for (int attempts = 1; attempts <= maxAttempts; attempts++)
	 {
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber)
		 {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempts + 1;
                    break;
                } 
		else if (userGuess < targetNumber) 
		{
                    System.out.println("Too low. Try again.");
                } 	
		else
		 {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == maxAttempts) 
		{
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
        }

	 while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Game Over. Your total score is: " + score);
    }
}
