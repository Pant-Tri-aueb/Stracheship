public class Main { // Mia apli main gia na trexei h Deck.java //
    public static void main(String[] args) {
        Deck a = new Deck();
        a.PrintArray();
        System.out.print("\n\n");
        a.shipPlacement(1, 1, 4,"RIGHT");
        a.PrintArray();
    }
    
}