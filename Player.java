public class Player {

    String name;
    int runs;
    int balls;
    int fours;
    int sixes;
    boolean out;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.balls = 0;
        this.fours = 0;
        this.sixes = 0;
        this.out = false;
    }

    public void addRuns(int run) {
        runs += run;
        balls++;

        if (run == 4)
            fours++;

        if (run == 6)
            sixes++;
    }

    public double getStrikeRate() {
        if (balls == 0)
            return 0;

        return (runs * 100.0) / balls;
    }

    public void displayPlayer() {

        System.out.printf("%-15s %4d %4d %4d %4d %8.2f%n",
                name,
                runs,
                balls,
                fours,
                sixes,
                getStrikeRate());
    }
}