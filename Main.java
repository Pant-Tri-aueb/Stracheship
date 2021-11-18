import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //about Player class

        // Player A

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter info about player 1");
        System.out.println("Provide a valid name");
        String answer_1 = keyboard.nextLine();
        System.out.println("Are you a male or a female?");
        String answer_2 = keyboard.nextLine();
        System.out.println("Enter a valid age");
        int answer_3 = keyboard.nextInt();
        Player A = new Player(answer_1, answer_2, answer_3);

        //Player B

        System.out.println("Enter info about player 2");
        System.out.println("Provide a valid name");
        String answer_1b = keyboard.nextLine();
        System.out.println("Are you a male or a female?");
        String answer_2b = keyboard.nextLine();
        System.out.println("Enter a valid age");
        int answer_3b = keyboard.nextInt();
        Player B = new Player(answer_1b, answer_2b, answer_3b);

        // Ships

        Ship2 A = new Ship2('A', 1, 2);
        Ship2 B = new Ship2('B', 2, 3);
        Ship2 C = new Ship2('C', 3, 4);
        Ship2 D = new Ship2('D', 4, 5);


    }

}
