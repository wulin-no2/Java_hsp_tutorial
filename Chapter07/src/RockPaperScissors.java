import java.util.Scanner;

public class RockPaperScissors {
    Scanner scanner = new Scanner(System.in);
    int gesture;
    int numWin;
    int numLose;
    int numTie;

    public void play() {
        do {
            int computer = (int) Math.round(2 * Math.random());
            System.out.println("the computer gave you " + computer);
            System.out.println("please give your gesture: ");
            gesture = scanner.nextInt();
            if (gesture > 2) {
                System.out.println("Game over.");
                System.out.println("you wined "+ numWin);
                System.out.println("you lost "+ numLose);
                System.out.println("you tied "+ numTie);
                break;
            } else if (computer == gesture) {
                System.out.println("you tied.");
                numTie++;
                System.out.println("And you tied " + numTie);
            } else if (computer > gesture) {
                System.out.println("you wined");
                numWin++;
                System.out.println("And you wined " + numWin);
            } else {
                System.out.println("you lost");
                numLose++;
                System.out.println("And you lost " + numLose);
            }
        } while (true);
    }
}