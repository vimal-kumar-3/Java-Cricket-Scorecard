import java.util.ArrayList;

public class Team {

    String teamName;

    ArrayList<Player> players;
    ArrayList<Bowler> bowlers;

    int totalRuns;
    int wickets;
    int extras;

    public Team(String teamName) {

        this.teamName = teamName;

        players = new ArrayList<>();
        bowlers = new ArrayList<>();

        totalRuns = 0;
        wickets = 0;
        extras = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addBowler(Bowler bowler) {
        bowlers.add(bowler);
    }

    public void addRuns(int runs) {
        totalRuns += runs;
    }

    public void addExtra(int extra) {
        extras += extra;
        totalRuns += extra;
    }

    public void wicketFell() {
        wickets++;
    }

    public void displayTeamInfo() {

        System.out.println("Team : " + teamName);
        System.out.println("Runs : " + totalRuns);
        System.out.println("Wickets : " + wickets);
        System.out.println("Extras : " + extras);

    }

}