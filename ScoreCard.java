public class ScoreCard {

    public void display(Team battingTeam,
                        Team bowlingTeam,
                        Player striker,
                        Player nonStriker,
                        Bowler currentBowler,
                        int totalBalls) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              " + battingTeam.teamName.toUpperCase());
        System.out.println("==========================================");

        System.out.println("Score : " + battingTeam.totalRuns + "/" + battingTeam.wickets);
        System.out.println("Overs : " + (totalBalls / 6) + "." + (totalBalls % 6));

        System.out.println();

        System.out.println("BATTERS");
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %4s %4s %4s %4s %8s%n",
                "Player", "Status", "R", "B", "4s", "6s", "SR");
        System.out.println("----------------------------------------------------------------------------");

        System.out.printf("%-15s %-15s %4d %4d %4d %4d %8.2f%n",
                striker.name,
                "*Striker",
                striker.runs,
                striker.balls,
                striker.fours,
                striker.sixes,
                striker.getStrikeRate());

        System.out.printf("%-15s %-15s %4d %4d %4d %4d %8.2f%n",
                nonStriker.name,
                "Non-Striker",
                nonStriker.runs,
                nonStriker.balls,
                nonStriker.fours,
                nonStriker.sixes,
                nonStriker.getStrikeRate());

        System.out.println();

        System.out.println("BOWLING");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-15s %-8s %-8s %-8s %-8s %-8s %-8s%n",
                "Bowler", "Overs", "Runs", "Wkts", "WD", "NB", "Eco");
        System.out.println("----------------------------------------------------------------");

        for (Bowler bowler : bowlingTeam.bowlers) {
            bowler.displayBowler();
        }

        System.out.println("==========================================");
    }


    // ================= FINAL SCORECARD =================

    public void displayFinalScoreCard(Team battingTeam,
                                      Team bowlingTeam,
                                      int totalBalls) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          FINAL SCORECARD");
        System.out.println("==========================================");

        System.out.println();
        System.out.println("BATTING");
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-15s %-10s %4s %4s %4s %4s %8s%n",
                "Player", "Status", "R", "B", "4s", "6s", "SR");
        System.out.println("----------------------------------------------------------------------------");

      for (Player player : battingTeam.players) {

                String status;

                if (player.out) {
                        status = "Out";
                } else {
                        status = "Not Out";
                }

                System.out.printf("%-15s %-10s %4d %4d %4d %4d %8.2f%n",
                        player.name,
                        status,
                        player.runs,
                        player.balls,
                        player.fours,
                        player.sixes,
                        player.getStrikeRate());
       }

        System.out.println();

        System.out.println("BOWLING");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-15s %-8s %-8s %-8s %-8s %-8s %-8s%n",
          "Bowler", "Overs", "Runs", "Wkts", "WD", "NB", "Eco");
        System.out.println("----------------------------------------------------------------");

        for (Bowler bowler : bowlingTeam.bowlers) {
            bowler.displayBowler();
        }

        System.out.println();

        System.out.println("TOTAL : " +
                battingTeam.totalRuns + "/" + battingTeam.wickets);

        System.out.println("Overs : " +
                (totalBalls / 6) + "." + (totalBalls % 6));

        System.out.println("==========================================");
    }
}