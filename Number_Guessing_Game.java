import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();
		int numberToGuess = rand.nextInt(100) + 1; // Random number between 1 and 100
		Scanner scanner = new Scanner(System.in);
		int guess = 0;

		System.out.println("Welcome to the number guessing game!");
		System.out.println("Guess a number between 1 and 100:");

		while (true) {
			try {
				guess = scanner.nextInt(); // Read user input

				// Validate the guess
				if (guess < 1 || guess > 100) {
					System.out.println("Please guess a number within the range of 1 to 100.");
					continue; // Skip to the next iteration of the loop
				}

				// Check the guess against the number to guess
				if (guess == numberToGuess) {
					System.out.println("Congratulations, you guessed the number!");
					break; // Exit the loop if guessed correctly
				} else if (guess < numberToGuess) {
					System.out.println("Your guess is too low. Try again:");
				} else {
					System.out.println("Your guess is too high. Try again:");
				}
			} catch (InputMismatchException e) {
				System.out.println("That's not a valid number. Please enter an integer between 1 and 100.");
				scanner.next(); // Clear the invalid input
			}
		}

		scanner.close(); // Close the scanner resource
	}
}