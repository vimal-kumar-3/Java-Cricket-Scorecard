import java.util.Scanner;
public class Innings {

    Team battingTeam;
    Team bowlingTeam;

    Player striker;
    Player nonStriker;

    Bowler currentBowler;

    int totalBalls;
    int nextPlayerIndex = 2;
    int target;
    int maxOvers;
    int maxBalls;

    Scanner sc = new Scanner(System.in);
    ScoreCard scoreCard = new ScoreCard();

    public Innings(Team battingTeam, Team bowlingTeam, int maxOvers) {

    this.battingTeam = battingTeam;
    this.bowlingTeam = bowlingTeam;
    
    this.maxOvers = maxOvers;
    this.maxBalls = maxOvers * 6;

    striker = battingTeam.players.get(0);
    nonStriker = battingTeam.players.get(1);

    nextPlayerIndex = 2;

    currentBowler = bowlingTeam.bowlers.get(0);

    scoreCard = new ScoreCard();
}

    public void startInnings() {
       

    while (totalBalls <  maxBalls &&
            battingTeam.wickets < 10 &&
            (target == 0 || battingTeam.totalRuns < target)) {

          scoreCard.display(
            battingTeam,
            bowlingTeam,
            striker,
            nonStriker,
            currentBowler,
            totalBalls);

            System.out.print("\nEnter Ball Result: ");

            String input = sc.next();

            processBall(input);
        }

        if (target > 0 && battingTeam.totalRuns >= target) {
            System.out.println();
            System.out.println("==========================================");
            System.out.println(battingTeam.teamName + " chased the target successfully!");
            System.out.println("==========================================");
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("         INNINGS FINISHED");
        System.out.println("==========================================");
        System.out.println("Final Score : "
                + battingTeam.totalRuns + "/"
                + battingTeam.wickets);

        System.out.println("Overs : "
                + (totalBalls / 6) + "."
                + (totalBalls % 6));
        System.out.println("==========================================");

        scoreCard.displayFinalScoreCard(
        battingTeam,
        bowlingTeam,
        totalBalls);   
    }

    public void processBall(String input) {

        if (input.equals("0") || input.equals("1") || input.equals("2")
                || input.equals("3") || input.equals("4")
                || input.equals("6")) {

            int runs = Integer.parseInt(input);

            battingTeam.addRuns(runs);
            striker.addRuns(runs);
            currentBowler.bowlBall(runs);

            totalBalls++;

            if (runs % 2 != 0) {
                changeStrike();
            }

            if (totalBalls % 6 == 0) {
                changeStrike();
                nextBowler();
            }
        }

        else if (input.equalsIgnoreCase("W")) {

            battingTeam.wicketFell();

            striker.out = true;

            striker.balls++;          // Count the ball faced by the batsman

            currentBowler.wicket();
            currentBowler.bowlBall(0);

            totalBalls++;

            nextBatsman();

            if (totalBalls % 6 == 0) {
                changeStrike();
                nextBowler();
            }
    }

        else if (input.equalsIgnoreCase("WD")) {

            battingTeam.addExtra(1);
            currentBowler.wide();
        }

        else if (input.equalsIgnoreCase("NB")) {

            battingTeam.addExtra(1);
            currentBowler.noBall();
        }

        else {

            System.out.println("Invalid Input!");

        }
    }

    public void changeStrike() {

        Player temp = striker;
        striker = nonStriker;
        nonStriker = temp;

    }

    public void nextBatsman() {

        if (nextPlayerIndex < battingTeam.players.size()) {

            striker = battingTeam.players.get(nextPlayerIndex);
            nextPlayerIndex++;

        } else {

            System.out.println("All players are out.");

        }

    }

 public void nextBowler() {

    System.out.println("\n--------------------------------");
    System.out.println("Over Finished");
    System.out.println("Previous Bowler : " + currentBowler.name);
    System.out.println("--------------------------------");

    int[] bowlerIndex = new int[bowlingTeam.bowlers.size()];
    int option = 1;

    System.out.println("Choose Next Bowler:");

    for (int i = 0; i < bowlingTeam.bowlers.size(); i++) {

        Bowler bowler = bowlingTeam.bowlers.get(i);

        if (bowler != currentBowler) {

            System.out.println(option + ". " + bowler.name);

            bowlerIndex[option] = i;
            option++;
        }
    }

    int choice;

    while (true) {

        System.out.print("Enter Choice : ");
        choice = sc.nextInt();

        if (choice >= 1 && choice < option) {
            break;
        }

        System.out.println("Invalid Choice! Try Again.");
    }

    currentBowler = bowlingTeam.bowlers.get(bowlerIndex[choice]);

    System.out.println("Current Bowler : " + currentBowler.name);
}

}