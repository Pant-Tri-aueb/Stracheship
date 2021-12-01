import java.util.ArrayList;
import java.util.List;

public class Deck {

    public String[][] deck_arr = new String[10][10];

    public Deck() {  // arxikopoiei pinaka 2x2 pou deixnei to deck tou paixth me "O" tis theseis tou Deck//
        DeckInitialization();
    }
    
    Ship2 pl11 = new Ship2();
    Ship2 pl12 = new Ship2();
    Ship2 pl13 = new Ship2();
    Ship2 pl14 = new Ship2();
    Ship2 pl15 = new Ship2();
    
   
    public void shipPlacement(int x,int y,int size,String direction) {
        // Topothetisi ploiou opoy x kai y oi syntetagmenes enos simeioy,
        // size to megethos toy ploioy kai direction to ean mpainei to ploio katheta h orizontia
        boolean check = ShipCheckOveral(x, y, size, direction);
        int i;
        int counter = 1;
        if (check == true) {
        	switch (counter) {
        	  case 1:
        		  Ship2 pl11 = new Ship2(x,y,size,direction);
        	    break;
        	  case 2:
        		  Ship2 pl12 = new Ship2(x,y,size,direction);
        	  case 3:
        		  Ship2 pl13 = new Ship2(x,y,size,direction);
        	    break;
        	  case 4:
        		  Ship2 pl14 = new Ship2(x,y,size,direction);
        	    break;
        	  case 5:
        		  Ship2 pl15 = new Ship2(x,y,size,direction);
        	    break;
        	}
        	counter++;
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
    	System.out.println("Αυτό είναι το ταμπλό του παιχνιδιού Strachesip: ");
    	for(int i = 0 ; i < this.deck_arr[0].length ; i ++) {
            if (i == 0) {System.out.println("+ | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|\n___________________________________________");}
            for(int j = 0 ; j < this.deck_arr.length ; j ++) {
                if (j == 0 && i != 9) {
                    System.out.print(i + 1 + " | " + this.deck_arr[i][j] + " | ");
                } else if (j == 0 && i == 9) {
                    System.out.print(i + 1 + "| " + this.deck_arr[i][j] + " | ");
                } else { 
                    System.out.print(this.deck_arr[i][j] + " | ");
                }
                if (j == 9) {System.out.print("\n");}
            }
        }
        
    }

    // Methodo elegxou topothetishs ploiou ston pinaka //
    public boolean ShipOutOfDeckCheck(int x, int y, int size, String direction) {
        boolean checkship = true;
        if ((x > 10) || (y > 10)) {
            System.out.println("Άκυρη τοποθέτηση πλοίου.\nΟι συντεταγμένες του πλοίου δεν υπάρχουν στο ταμπλό!");
            checkship = false;
        } else if (((direction.equals("RIGHT")) && (y + size - 1 > 10)) || ((direction.equals("DOWN")) && (x + size - 1 > 10))) {
            System.out.println("Άκυρη τοποθέτηση πλοίου.\nΤο πλοίο βγαίνει εκτός ταμπλό παιχνιδιού!");
            checkship = false;
        }
        return checkship;
    }
    
    //Mεθοδο που ελεγχει εαν το πλοιο που παει να τοποθετηθει, παει να τοποθετηθει πανω σε αλλο
    public boolean ShipOnShipCheck(int x, int y, int size, String direction) {
        int i;
        boolean checkship = true;
        try {
            if (direction.equals("RIGHT")) {
                for (i = y ; i < size + y ; i++){
                    if (this.deck_arr[x-1][i-1] == "S") {
                	     checkship = false;
                	     System.out.println("Στην γραμμή " + x + " και σειρά " + i + " υπάρχει άλλο πλοίο!");
                    }
                }
             } else if (direction.equals("DOWN")) {
                 for (i = x ; i < size + x ; i++){
                     if (this.deck_arr[i-1][y-1] == "S") {
                         checkship = false;
                         System.out.println("Στην γραμμή " + x + " και σειρά " + i + " υπάρχει άλλο πλοίο!");
                     }
                 }
             } 
         return checkship;
        } catch (Exception e) {
        	checkship = false;
        	return checkship;
        }
    
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
