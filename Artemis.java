import java.util.Scanner;

public class Artemis {

    private static int RIVAL_MOVES = 2;
    private static boolean used = false;

    // another class interacts to use or not defence
    public static void askPlayer() {
        boolean valid = true;
        String validAnswer[] = {"Yes", "No"};
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Would you like to use your power?");
            System.out.println("Answer with a YES or a NO.");
            String answer = keyboard.nextLine();
            if (answer.equals(validAnswer[0])) {
                System.out.println("Ok. Power used. Available power for defence :" + --RIVAL_MOVES);
                used = true;
            } else if (answer.equals(validAnswer[1])) {
                System.out.println("Ok. No power used. Available power for defence :" + RIVAL_MOVES);
            } else {
                valid = false;
                System.out.println("Provide a valid answer");
            }
        } while (valid = false);
    }

    public static void useDefence(Ship3 obj) { // the ship that uses the power
        askPlayer();
        if (used == true) {
            int changeTolerance = obj.getTolerance();
            obj.setTolerance(++changeTolerance);
        }
    }

    public static void throwArrow(Ship3 obj, int x, int y, Deck deck) {
        if (obj.getY() != y) {
            System.out.println(" The ship can throw the arrow only horizontally. Try again.");
            return;
        }
        if (deck.deck_arr[x - 1][y - 1] == "S") {
            obj.setTolerance(0);
        } else if (deck.deck_arr[x - 1][y - 1] == "O") {
            System.out.println("Didn't hit a ship");

        }
    }
}
