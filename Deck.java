public class Deck {  //Mia malakia pou ekana ston eleuthero moy xrono //

    private String[][] deck_arr = new String[10][10];

    public Deck() {  // arxikopoiei pinaka 2x2 pou deixnei to deck tou paixth me "O" tis theseis tou Deck//
        DeckInitialization();
    }

    public void DeckInitialization() { // Methodo arxikopoihshs tou Deck //

        for(int i=0 ; i<10 ; i++) {
            for(int j=0 ; j<10 ; j++) {
                this.deck_arr[i][j] = "O";
            }
        }
    }

    public void shipPlacement(int x,int y,int size,String direction) {
        // Topothetisi ploiou opoy x kai y oi syntetagmenes enos simeioy,
        // size to megethos toy ploioy kai direction to ean mpainei to ploio katheta h orizontia
        // Ayth h methodo thelei kai ena check gia tin periptosh topothethshs ploiou pou den xoraei sto Deck//

        int i; 
        if (direction.equals("RIGHT")) {
             for (i = y ; i < size + 1 ; i++){
                 this.deck_arr[x-1][i-1] = "S";
             }
         } else if (direction.equals("DOWN")) {
             for (i = x; i < size + 1 ; i++){
                this.deck_arr[i-1][y-1] = "S";
            }
         }
    }

    public void PrintArray(){  // Aplh voithitikh methodo gia Print tou Deck//
        for(int i=0 ; i<10 ; i++) {
            for(int j=0 ; j<10 ; j++) {
                System.out.print(this.deck_arr[i][j]);
                if (j == 9){System.out.print("\n");}
            }
        }
        
    }

    







}