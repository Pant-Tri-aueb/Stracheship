import java.util.Scanner;

public class Artemis {

    private static int[] RIVAL_MOVES = {2,2};
    private boolean used = false;
    private int playerNo;

    public Artemis(int playerNo) {
        this.playerNo = playerNo;
    }

    // another class interacts to use or not defence
    public void askPlayer() {
        boolean valid = true;
        String validAnswer[] = {"Yes", "No"};
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Would you like to use your power?");
            System.out.println("Answer with a YES or a NO.");
            String answer = keyboard.nextLine();
            outer : if (answer.equals(validAnswer[0])) {
                if (RIVAL_MOVES[playerNo - 1] <= 0) {
                    System.out.println("No more power available");
                    break outer;
                }
                System.out.println("Ok. Power used. Available power for defence :" + --RIVAL_MOVES[playerNo - 1]);
                used = true;
            } else if (answer.equals(validAnswer[1])) {
                System.out.println("Ok. No power used. Available power for defence :" + RIVAL_MOVES[playerNo - 1]);
            } else {
                valid = false;
                System.out.println("Provide a valid answer");
            }
        } while (valid = false);
    }

    public void useDefence(Ship3 obj) { // the ship that uses the power
        askPlayer();
        if (used == true) {
            int changeTolerance = obj.getTolerance();
            obj.setTolerance(++changeTolerance);
        }
    }

    public void throwArrow(Ship3 obj, Deck deck) {
        ArtemisArrow a = new ArtemisArrow();
        /*if (deck.deck_arr[a.textField.getText() - 1][y - 1] == "S") {
            obj.setTolerance(0);
        } else if (deck.deck_arr[x - 1][y - 1] == "O") {
            System.out.println("Didn't hit a ship");

        }
    *//
    }
}
