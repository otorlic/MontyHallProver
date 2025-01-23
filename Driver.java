import java.util.Scanner;

public class Driver {

    public static void main(String[] theArgs) {

        Monty monty = new Monty();

        Scanner in = new Scanner(System.in);
        int numOfTests;

        System.out.print("Please enter how many time would you like to repeat this experiment: ");
        numOfTests = in.nextInt();
        System.out.println();

        monty.playGame(numOfTests);
    }
}
