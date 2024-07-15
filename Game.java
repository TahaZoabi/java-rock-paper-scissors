import java.util.Scanner;

public class Game {
    public static void playGame() {
        Scanner input = new Scanner(System.in);
        System.out.println(">>Let's play Rock Paper Scissors.\n" + "Are you ready? (yes/no)");
        String checkReady = input.nextLine();


        if (checkReady.equalsIgnoreCase("yes")) {
            System.out.println("Great! pick your choice \nrock - paper - scissors");
            String playerMove = input.nextLine();

            String computerChoice = computerChoice();
            String yourChoice = playerChoice(playerMove);


            System.out.println("\nYou chose: " + yourChoice);
            System.out.println("The computer chose: " + computerChoice);


            String result = displayResults(yourChoice, computerChoice);
            System.out.println(result);

        }
        else if (checkReady.equalsIgnoreCase("no")) {
            System.out.println("We will be waiting for you xD");
        }
        else {
            System.out.println("Invalid Input please try again!");
        }
    }


    public static String computerChoice() {
        int randomNumber = (int) (Math.random() * 3);

        return switch (randomNumber) {
            case 0 -> "rock";
            case 1 -> "paper";
            case 2 -> "scissors";
            default -> throw new IllegalStateException("Unexpected value: " + randomNumber);
        };
    }


    public static String playerChoice(String move) {
        move = move.toLowerCase().trim();

        if (!(move.equals("rock") || move.equals("paper") || move.equals("scissors"))) {
            System.out.println("Invalid Input please choose a move (rock, paper, scissors");
        }
        return move;
    }


    public static String displayResults(String playMove, String compMove) {

        if (playMove.equals(compMove)) {
            return "Draw!";
        }
        else {
            return switch (compMove) {
                case "rock" -> (playMove.equals("paper")) ? "You Win" : "You Lose";
                case "paper" -> (playMove.equals("scissors")) ? "You Win" : "You Lose";
                case "scissors" -> (playMove.equals("rock")) ? "You Win" : "You Lose";
                default -> throw new IllegalStateException("Unexpected Error");
            };
        }
    }
}
