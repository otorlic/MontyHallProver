import java.util.Random;

public class Monty {

    private int[] doors;

    private int wins;

    private int fails;

    public Monty() {
        doors = new int[]{0, 0, 1};
        wins = 0;
        fails = 0;
    }


    public void playGame(int n) {
        System.out.println("Let the game begin!!");

        for (int i = 0; i < n; i++) {

            shuffleArray(doors); // Shuffle the order

            Random selector = new Random();
            int choice = selector.nextInt(3); // Randomly choose a door

            int open = selector.nextInt(3); // Open one that's not the selected door and not the car

            while(choice == open || doors[open] == 1) {
                open = selector.nextInt(3);
            }

            int swap = 3 - choice - open; // switch to the other door

            if (doors[swap] == 1) {
                wins++; // If it's a king, mark a win
            } else {
                fails++; // If it's a zero, mark a loss
            }

            //System.out.println(this + " Inital choice: " + choice + ", Door opened: " + open + ", Swapped to: " + swap);

        }
        System.out.println("Number of Wins: " + wins);
        System.out.println("Number of Fails: " + fails);

        double percentage = (double) wins / (wins + fails);
        percentage *= 100;

        System.out.printf("Wins Percentage: %.4f%%", percentage);
    }

    // Implementing Fisher–Yates shuffle
    private void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    @Override
    public String toString() {
        return "[" + doors[0] + ", " + doors[1] + ", " + doors[2] + "]";
    }




}
