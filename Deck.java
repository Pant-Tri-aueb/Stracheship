public class Deck {

    private String[][] deck_arr = new String[10][10];

    public Deck() {  // arxikopoiei pinaka 2x2 pou deixnei to deck tou paixth me "O" tis theseis tou Deck//
        DeckInitialization();
    }

    public void shipPlacement(int x,int y,int size,String direction) {
        // Topothetisi ploiou opoy x kai y oi syntetagmenes enos simeioy,
        // size to megethos toy ploioy kai direction to ean mpainei to ploio katheta h orizontia
        boolean check = ShipCheckOveral(x, y, size, direction);
        int i;
        if (check == true) {
            if(direction.equals("DOWN")) {
                for (i = x ; i < size + x ; i++){
                    this.deck_arr[i-1][y-1] = "S";
                }
            } else if (direction.equals("RIGHT")) {
                for (i = y ; i < size + y ; i++){
                    this.deck_arr[x-1][i-1] = "S";
                }  
            }
        }
    }

    public void DeckInitialization() { // Methodo arxikopoihshs tou Deck //

        for(int i=0 ; i<10 ; i++) {
            for(int j=0 ; j<10 ; j++) {
                this.deck_arr[i][j] = "O";
            }
        }
    }

    public void PrintArray(){  // Aplh voithitikh methodo gia Print tou Deck//
    	System.out.println("Αυτό είναι το ταμπλό του παιχνιδιού Strachesip:");
    	for(int i=0 ; i<10 ; i++) {
            for(int j=0 ; j<10 ; j++) {
                System.out.print(this.deck_arr[i][j]);
                if (j == 9){System.out.print("\n");}
            }
        }
        
    }

    // Methodo elegxou topothetishs ploiou ston pinaka //
    /* Η μεθοδος αυτη βγαζει outofbounds exception οταν τρεχει το σημειο που εχω βαλει αστερακια.  Δειτε το οποιος μπορει γιατι δεν ξερω τι παιζει*/
    public boolean ShipOutOfDeckCheck(int x, int y, int size, String direction) {
        boolean checkship = true;
        if ((x > 10) || (y > 10)) {
            System.out.println("Άκυρη τοποθέτηση πλοίου.\nΟι συντεταγμένες του πλοίου δεν υπάρχουν στο ταμπλό!");
            checkship = false;
        }
        if (((direction.equals("RIGHT")) && (y + size - 1 > 10)) || ((direction.equals("DOWN")) && (x + size - 1 > 10))) { /******************************/
            System.out.println("Άκυρη τοποθέτηση πλοίου.\nΤο πλοίο βγαίνει εκτός ταμπλό παιχνιδιού!");
            checkship = false;
        }
        return checkship;
    }
    //Mεθοδο που ελεγχει εαν το πλοιο που παει να τοποθετηθει, παει να τοποθετηθει πανω σε αλλο
    public boolean ShipOnShipCheck(int x, int y, int size, String direction) {
        int i;
        boolean checkship = true;
        if (direction.equals("RIGHT")) {
            for (i = y ; i < size + y ; i++){
                if (this.deck_arr[x-1][i-1] == "S") {
                	 checkship = false;
                	 System.out.println("Στην γραμμή " + x + " και σειρά " + i + " υπάρχει άλλο πλοίο");
                }
            }
        } else if (direction.equals("DOWN")) {
            for (i = x ; i < size + x ; i++){
                if (this.deck_arr[i-1][y-1] == "S") {
                    checkship = false;
                    System.out.println("Στην γραμμή " + x + " και σειρά " + i + " υπάρχει άλλο πλοίο");
                }
            }
        }
        return checkship;
    }
    // METHODO POU SINDIAZEI TOYS ELEGXOUS SHIPONSHIP KAI SHIPOUTOFDECK KAI VGAZEI 1 APOTELESMA
    public boolean ShipCheckOveral(int x, int y, int size, String direction) {
        boolean finalcheck = false;
        boolean flag1;
        boolean flag2;
        final String RIGHT = "RIGHT";
        final String DOWN = "DOWN";
        if (direction.equals(RIGHT)) {
            flag1 = ShipOutOfDeckCheck(x, y, size, RIGHT);
            flag2 = ShipOnShipCheck(x, y, size, RIGHT);
            if ((flag1 == true) && (flag2 == true)) {
            	finalcheck = true;
            }
        } else if (direction.equals(DOWN)) {
            flag1 = ShipOutOfDeckCheck(x, y, size, DOWN);
            flag2 = ShipOnShipCheck(x, y, size, DOWN);
            if ((flag1 == true) && (flag2 == true)) {
            	finalcheck = true;
            }
        }
        return finalcheck;
    }
}   
