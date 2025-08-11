import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("\nI'm thinking of a number between 1 and 100.");
        System.out.println("\nYou have 5 chances to guess the correct number.");

        int numberToGuess = (int) (Math.random() * 100) + 1;
        int numberOfTries = 0;
        int userGuess = 0;
        String difficultyLevel = "easy";
        boolean hasGuessedCorrectly = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a difficulty level: easy, medium, or hard.");
        difficultyLevel = scanner.nextLine();

        if (difficultyLevel.equals("easy")) {
            numberOfTries = 20;
        } else if (difficultyLevel.equals("medium")) {
            numberOfTries = 10;
        } else if (difficultyLevel.equals("hard")) {
            numberOfTries = 5;
        } else {
            System.out.println("Invalid difficulty. Defaulting to easy.");
            numberOfTries = 20;
        }

        while (numberOfTries > 0 && !hasGuessedCorrectly) {
            System.out.println("\nYou have " + numberOfTries + " tries left.");
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // descarta entrada inválida
                continue;
            }

            userGuess = scanner.nextInt();
            scanner.nextLine(); // consome o restante da linha

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Your guess is out of range. Please guess a number between 1 and 100.");
                continue;
            }

            if (userGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the correct number: " + numberToGuess);
            } else if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }

            numberOfTries--;
        }
        scanner.close();
    }
}