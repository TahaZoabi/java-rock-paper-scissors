import java.util.Scanner;

public class Game {
    private static final Scanner input = new Scanner(System.in);
    private static int playerScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        System.out.println(">> Let's play Rock Paper Scissors.\nAre you ready? (yes/no)");
        String checkReady = input.nextLine();

        if (checkReady.equalsIgnoreCase("yes")) {
            playRound();
        }
        else if (checkReady.equalsIgnoreCase("no")) {
            System.out.println("We will be waiting for you xD");
        }
        else {
            System.out.println("Invalid input, please try again!");
            playGame();
        }
    }

    public static void playRound() {
        System.out.println("Great! Pick your choice: rock - paper - scissors");
        String playerMove = playerChoice();

        String computerMove = computerChoice();
        System.out.println("\nYou chose: " + playerMove);
        System.out.println("The computer chose: " + computerMove);

        String result = displayResults(playerMove, computerMove);
        System.out.println(result);


        if (result.equals("You Win")) {
            playerScore++;
        }
        else if (result.equals("You Lose")) {
            computerScore++;
        }


        System.out.println("Score - You: " + playerScore + " Computer: " + computerScore);

        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = input.nextLine();
        if (playAgain.equalsIgnoreCase("yes")) {
            playRound();
        }
        else {
            System.out.println("Thank you for playing!");
        }
    }

    public static String playerChoice() {
        while (true) {
            String move = input.nextLine().toLowerCase().trim();
            if (move.equals("rock") || move.equals("paper") || move.equals("scissors")) {
                return move;
            }
            else {
                System.out.println("Invalid input. Please choose again (rock, paper, scissors):");
            }
        }
    }

    public static String computerChoice() {
        int randomNumber = (int) (Math.random() * 3);

        switch (randomNumber) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }

    public static String displayResults(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw!";
        }
        else {
            switch (computerMove) {
                case "rock":
                    return (playerMove.equals("paper")) ? "You Win" : "You Lose";
                case "paper":
                    return (playerMove.equals("scissors")) ? "You Win" : "You Lose";
                case "scissors":
                    return (playerMove.equals("rock")) ? "You Win" : "You Lose";
                default:
                    throw new IllegalStateException("Unexpected Error");
            }
        }
    }
}
