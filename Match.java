import java.util.Scanner;
import java.util.Random;

public class Match {

    Team team1;
    Team team2;

    Team battingTeam;
    Team bowlingTeam;

    int target;

    Scanner sc = new Scanner(System.in);

    public Match(Team team1, Team team2) {

        this.team1 = team1;
        this.team2 = team2;
    }

    public void toss() {

        Random random = new Random();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("                 TOSS");
        System.out.println("==========================================");
        System.out.println();

        System.out.println(team1.teamName + ", choose:");
        System.out.println("1. Head");
        System.out.println("2. Tail");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        int tossResult = random.nextInt(2) + 1;

        System.out.println();

        System.out.print("Toss Result : ");

        if (tossResult == 1) {
            System.out.println("Head");
        } else {
            System.out.println("Tail");
        }

        Team tossWinner;

        if (choice == tossResult) {
            tossWinner = team1;
        } else {
            tossWinner = team2;
        }

        System.out.println(tossWinner.teamName + " won the toss.");

        System.out.println();
        System.out.println("Choose:");
        System.out.println("1. Batting");
        System.out.println("2. Bowling");
        System.out.print("Enter Choice: ");

        int decision = sc.nextInt();

        if (decision == 1) {

            battingTeam = tossWinner;

            bowlingTeam = (tossWinner == team1) ? team2 : team1;

        } else {

            bowlingTeam = tossWinner;

            battingTeam = (tossWinner == team1) ? team2 : team1;
        }

        System.out.println();
        System.out.println(battingTeam.teamName + " will bat first.");
        System.out.println(bowlingTeam.teamName + " will bowl first.");
    }

    public void setTarget() {

        target = battingTeam.totalRuns + 1;
    }

    public void displayWinner() {

        if (battingTeam.totalRuns >= target) {

            System.out.println(battingTeam.teamName + " won the match.");

        } else {

            System.out.println(bowlingTeam.teamName + " won the match.");
        }
    }
}