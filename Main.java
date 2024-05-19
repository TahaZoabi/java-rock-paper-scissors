import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println(">>Let's play Rock Paper Scissors.\n" +
                ">>When I say 'shoot', Choose: rock, paper, or scissors.\n" +
                "\n" +
                ">>Are you ready? Write 'yes' if you are\n");

        String playerReady = input.nextLine();
        if (playerReady.equalsIgnoreCase("yes")) {
            System.out.println("Great! \nrock - paper - scissors, shoot!");
            String playerMove = input.nextLine();
            String computerChoice = computerChoice();
            String yourChoice = playerChoice(playerMove);
            System.out.println("\nYou chose:" + yourChoice);
            System.out.println("The computer chose: " + computerChoice);

           String result =  displayResults(yourChoice, computerChoice);
            System.out.println(result);

        }
        else {
            System.out.println("Darn, maybe some other time...!");
        }

    }

    public static String computerChoice() {
        int randomNumber = (int) (Math.random() * 3);

        return switch (randomNumber) {
            case 0 -> "rock";
            case 1 -> "paper";
            case 2 -> "scissors";
            default -> "";
        };
    }

    public static String playerChoice(String move) {
        return switch (move.toLowerCase()) {
            case "rock" -> "rock";
            case "paper" -> "paper";
            case "scissors" -> "scissors";
            default -> "";
        };
    }

    public static String displayResults(String playMove, String compMove) {

        String result ="";
        if (playMove.equals(compMove)) {
            System.out.println("Draw!");
        }
        else {
            result = switch (compMove) {
                case "rock" -> (playMove.equals("paper")) ? "You Win" : "You Loose";
                case "paper" -> (playMove.equals("rock")) ? "You Loose" : "You Win";
                case "scissors" -> (playMove.equals("paper")) ? "You Loose" : "You Win";
                default -> result;
            };
        }
        return result;
    }
}
