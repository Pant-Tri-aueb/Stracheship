public class Deck {

    private String[][] deck_arr = new String[10][10];

    public Deck(){
        DeckInitialization();
    }

    public void DeckInitialization() {

        for(int i=0 ; i<10 ; i++) {
            for(int j=0 ; j<10 ; j++) {
                this.deck_arr[i][j] = "O";
            }
        }
    }

    public void shipPlacement(int x,int y,int size,String direction) {
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

    public void PrintArray(){
        for(int i=0 ; i<10 ; i++) {
            for(int j=0 ; j<10 ; j++) {
                System.out.print(this.deck_arr[i][j]);
                if (j == 9){System.out.print("\n");}
            }
        }
        
    }







}