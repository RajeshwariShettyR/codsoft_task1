import java.util.Random;
import java.util.Scanner;

public class task1 {
    private static final int min_val= 1;
    private static final int max_val = 100;
    private static final int max_attempts = 10;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundNumber = 1;
        int score = 0;

        while (true) {
            System.out.println("\nBe ready for round number " + roundNumber + ":");
            int number = random.nextInt(max_val - min_val + 1) + min_val;
            int attempts = 0;
            boolean correctGuess = false;
            System.out.println("Start Guessing! Give any number between 1 to 100: ");
            

            while (attempts < max_attempts) {
                System.out.print("Enter your Guess Number : ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                
                attempts++;
                
                if (guess < number) 
                {
                    System.out.println(" It's low,try some high number!");
                } 
                else if (guess > number)
                {
                    System.out.println("It's high,try some low number!");
                } 
                else 
                {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.That's really ossum!");
                    correctGuess = true;
                    score++;
                    break;
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've used all " + max_attempts + " attempts. The correct number was " + number + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
            
            roundNumber++;
        }

        System.out.println("\nGame Over! You won " + score + " round(s).Well Done!, Thank you for playing!");
        scanner.close();
    }
}
