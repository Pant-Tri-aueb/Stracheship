public class ShipAttack {

    public void shipHit(int x, int y, Deck deck) {
        
        if (insideArrayCheck(x, y) == true ) {
            if (deck.deck_arr[x-1][y-1] == "S") {
                deck.deck_arr[x-1][y-1] = "X";
                System.out.println("Χτύπησατε πλοίο με συντεταγμένες : X = " + x + " και Υ = " + y + " !!");
            } else if (deck.deck_arr[x-1][y-1] == "O") {
                System.out.println("Στις συντεταγμκένες που επιλέξατε δεν υπάρχει αντίπαλο πλοίο !!");
            }
        }
    }

    public boolean insideArrayCheck(int x, int y) {
        if ((x < 11 && y < 11) && (x > 0 && y > 0)) {
            return true;
        } else {
            System.out.println("Οι συντεταγμένες που δώθηκαν δεν αντιστοιχούν σε ένα κουτάκι του πίνακα !!");
            return false;
        }
    }









}