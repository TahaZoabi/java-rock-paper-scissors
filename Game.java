import java.util.Scanner;

public class Game extends Main {

    public static void playGame() {
        Scanner input = new Scanner(System.in); // create a scanner to take user's input
        System.out.println(">>Let's play Rock Paper Scissors.\n" + "Are you ready? (yes/no)");
        String checkReady = input.nextLine(); // assign the user's answer if ready or not

        // check if the user is ready then start the game
        if (checkReady.equalsIgnoreCase("yes")) {
            // printing the choices for the user to choose from
            System.out.println("Great! pick your choice \nrock - paper - scissors");
            String playerMove = input.nextLine(); // assign the user's choice

            // call the computerChoice method and assign the returned value
            String computerChoice = computerChoice();
            // call the playerChoice method and assign the returned value (pass in the user's choice)
            String yourChoice = playerChoice(playerMove);

            // print both the  player's move and the computer's move
            System.out.println("\nYou chose: " + yourChoice);
            System.out.println("The computer chose: " + computerChoice);

            // calling the displayResults method and assign to a variable
            String result = displayResults(yourChoice, computerChoice);
            System.out.println(result); // print the results to the screen

        } // if the user says no we display a nice message for him
        else if (checkReady.equalsIgnoreCase("no")) {
            System.out.println("We will be waiting for you xD");
        }
        else { // if user writes anything else he would be asked to try again
            System.out.println("Invalid Input please try again!");
        }
    }

    // create a method to pick a computer move
    public static String computerChoice() {
        int randomNumber = (int) (Math.random() * 3); // generate a random number between 0-2
        switch (randomNumber) { // assign the computer move based on the random number
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber); // throw an error just in case something wrong happens with the random number
        }
    }

    // create a method to pick the player's move
    public static String playerChoice(String move) {
        // convert to lower case and remove all white spaces
        move = move.toLowerCase().trim();
        // check if the user writes something other than the option and display an error message
        if (!(move.equals("rock") || move.equals("paper") || move.equals("scissors"))) {
            System.out.println("Invalid Input please choose a move (rock, paper, scissors");
        }
        switch (move) { // confirming the player's move
            case "rock":
                return "rock";
            case "paper":
                return "paper";
            case "scissors":
                return "scissors";
            default:
                throw new IllegalStateException("Unexpected Error ");
        }
    }

    // create a method to display the result of the game
    public static String displayResults(String playMove, String compMove) {
        // check for a draw condition
        if (playMove.equals(compMove)) {
            return "Draw!";
        }
        else { // check the winner bases on the game logic
            switch (compMove) {
                case "rock":
                    return (playMove.equals("paper")) ? "You Win" : "You Lose";
                case "paper":
                    return (playMove.equals("scissors")) ? "You Win" : "You Lose";
                case "scissors":
                    return (playMove.equals("rock")) ? "You Win" : "You Lose";
                default:
                    throw new IllegalStateException("Unexpected Error");
            }
        }
    }
}
