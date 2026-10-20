public class Bowler {

    String name;
    int ballsBowled;
    int runsGiven;
    int wickets;
    int wides;
    int noBalls;

    public Bowler(String name) {
        this.name = name;
        this.ballsBowled = 0;
        this.runsGiven = 0;
        this.wickets = 0;
        this.wides = 0;
        this.noBalls = 0;
    }

    public void bowlBall(int runs) {
        ballsBowled++;
        runsGiven += runs;
    }

    public void wicket() {
        wickets++;
    }

    public void wide() {
        wides++;
        runsGiven++;
    }

    public void noBall() {
        noBalls++;
        runsGiven++;
    }

    public String getOvers() {
        return (ballsBowled / 6) + "." + (ballsBowled % 6);
    }

    public double getEconomy() {
        if (ballsBowled == 0)
            return 0;

        return runsGiven / (ballsBowled / 6.0);
    }

 public void displayBowler() {
    System.out.printf(
            "%-15s %-8s %-8d %-8d %-8d %-8d %-8.2f%n",
            name,
            getOvers(),
            runsGiven,
            wickets,
            wides,
            noBalls,
            getEconomy());
 }
}