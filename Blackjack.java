import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        int randomCardPlayer1 = drawRandomCard();
        int randomCardPlayer2 = drawRandomCard();
        System.out.println(
                "\n You get a \n" + cardString(randomCardPlayer1) + "\n and a \n" + cardString(randomCardPlayer2));

        int playerSum = Math.min(randomCardPlayer1, 10) + Math.min(randomCardPlayer2, 10);
        System.out.println("Your total is: " + playerSum);
        System.out.println();

        int dealerRandomCard1 = drawRandomCard();
        int dealerRandomCard2 = drawRandomCard();
        System.out.println("\n The dealer shows \n" + cardString(dealerRandomCard1) + "\nand has a card facing down\n"
                + faceDown());
        int dealerSum = Math.min(dealerRandomCard1, 10) + Math.min(dealerRandomCard2, 10);
        System.out.println("\nThe dealer's total is hidden");

        while (true) {
            String option = hitOrStay();
            if (option.equals("stay")) {
                break;
            }
            int playerRandomCard3 = drawRandomCard();
            playerSum += Math.min(playerRandomCard3, 10);
            System.out.println("\nYou get a \n" + cardString(playerRandomCard3));
            System.out.println("Your new total is: " + playerSum);

            if (playerSum > 21) {
                System.out.println("Bust! You lose!");
                System.exit(0);
            }

        }
        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are: \n" + cardString(dealerRandomCard1) + "\n and a \n" + cardString(dealerRandomCard2));
        System.out.println("\nDealer's total is " + dealerSum);

        while (dealerSum < 17) {
            int dealerRandomCard3 = drawRandomCard();
            dealerSum += Math.min(dealerRandomCard3, 10);
            System.out.println("\n Dealer gets a \n" + cardString(dealerRandomCard3));
            System.out.println("\nDealer's total is " + dealerSum);
        }

        if (dealerSum > 21) {
            System.out.println("Bust! Dealer loses!");
            System.exit(0);
        }

        if (playerSum > dealerSum) {
            System.out.println("Player Wins!");
        } else {
            System.out.println("Dealer Wins.");
        }
        scan.close();

    }

    public static int drawRandomCard() {
        return (int) (Math.random() * 13) + 1;
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";

            case 2:
                return

                "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";

            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";

            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";

            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return

                "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";

            case 8:
                return

                "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";

            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";

            case 11:
                return

                "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";

            case 12:
                return

                "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";

            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";

            default:
                return "Invalid option";
        }
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    public static String hitOrStay() {
        System.out.println("Hit or stay?");
        String option = scan.nextLine();
        // Approach 1
        while (!(option.equals("hit") || option.equals("stay"))) {
            System.out.println("Please write hit or stay.");
            option = scan.nextLine();
        }
        return option;
    }

}
