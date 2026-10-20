import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Available Teams");
        System.out.println("1. India");
        System.out.println("2. Australia");
        System.out.println("3. Pakistan");
        System.out.println("4. South Africa");

        System.out.print("\nSelect Team 1: ");
        int team1Choice = sc.nextInt();

        System.out.print("Select Team 2: ");
        int team2Choice = sc.nextInt();

        // sc.nextLine();

        String team1Name = "";
        String team2Name = "";

        switch (team1Choice) {
            case 1:
                team1Name = "India";
                break;
            case 2:
                team1Name = "Australia";
                break;
            case 3:
                team1Name = "Pakistan";
                break;
            case 4:
                team1Name = "South Africa";
                break;
        }

        switch (team2Choice) {
            case 1:
                team2Name = "India";
                break;
            case 2:
                team2Name = "Australia";
                break;
            case 3:
                team2Name = "Pakistan";
                break;
            case 4:
                team2Name = "South Africa";
                break;
        }

        Team team1 = new Team(team1Name);
        Team team2 = new Team(team2Name);

        sc.nextLine();

        String[] availablePlayers;

        switch (team1Choice) {

            case 1:
                availablePlayers = TeamDatabase.indiaPlayers;
                break;

            case 2:
                availablePlayers = TeamDatabase.australiaPlayers;
                break;

            case 3:
                availablePlayers = TeamDatabase.pakistanPlayers;
                break;

            default:
                availablePlayers = TeamDatabase.southAfricaPlayers;
        }

        System.out.println("\nPlayers of Team " + team1Name);
        for (int i = 0; i < availablePlayers.length; i++) {

            System.out.println((i + 1) + ". " + availablePlayers[i]);

        }

        System.out.println("\nSelect 11 Players");

        boolean[] selectedPlayers = new boolean[25];

        for (int i = 1; i <= 11; i++) {

            System.out.print("Player " + i + " : ");

            int choice = sc.nextInt();

            if (choice < 1 || choice > 25) {
                System.out.println("Invalid choice.");
                i--;
                continue;
            }

            if (selectedPlayers[choice - 1]) {
                System.out.println("Player already selected.");
                i--;
                continue;
            }

            selectedPlayers[choice - 1] = true;

            team1.addPlayer(new Player(availablePlayers[choice - 1]));
        }

        System.out.println("\nYour Playing XI");

        for (int i = 0; i < team1.players.size(); i++) {

            System.out.println((i + 1) + ". " + team1.players.get(i).name);

        }

    System.out.println("\nSelect 5 Bowlers from Playing XI");

    boolean[] selectedBowlers = new boolean[11];

    for (int i = 1; i <= 5; i++) {

        System.out.print("Bowler " + i + " : ");

        int choice = sc.nextInt();

        if (choice < 1 || choice > 11) {
            System.out.println("Invalid choice.");
            i--;
            continue;
        }

        if (selectedBowlers[choice - 1]) {
            System.out.println("Bowler already selected.");
            i--;
            continue;
        }

        selectedBowlers[choice - 1] = true;

        team1.addBowler(new Bowler(team1.players.get(choice - 1).name));
    }

        String[] availablePlayers2;

        switch (team2Choice) {

            case 1:
                availablePlayers2 = TeamDatabase.indiaPlayers;
                break;

            case 2:
                availablePlayers2 = TeamDatabase.australiaPlayers;
                break;

            case 3:
                availablePlayers2 = TeamDatabase.pakistanPlayers;
                break;

            default:
                availablePlayers2 = TeamDatabase.southAfricaPlayers;
        }

        System.out.println("\nPlayers of Team " + team2Name);

        for (int i = 0; i < availablePlayers2.length; i++) {

            System.out.println((i + 1) + ". " + availablePlayers2[i]);

        }

       System.out.println("\nSelect 11 Players");

        boolean[] selectedPlayers2 = new boolean[25];

        for (int i = 1; i <= 11; i++) {

            System.out.print("Player " + i + " : ");

            int choice = sc.nextInt();

            if (choice < 1 || choice > 25) {
                System.out.println("Invalid choice.");
                i--;
                continue;
            }

            if (selectedPlayers2[choice - 1]) {
                System.out.println("Player already selected.");
                i--;
                continue;
            }

            selectedPlayers2[choice - 1] = true;

            team2.addPlayer(new Player(availablePlayers2[choice - 1]));
        }

        System.out.println("\nYour Playing XI");

        for (int i = 0; i < team2.players.size(); i++) {

            System.out.println((i + 1) + ". " + team2.players.get(i).name);

        }

        System.out.println("\nSelect 5 Bowlers from Playing XI");

        boolean[] selectedBowlers2 = new boolean[11];

        for (int i = 1; i <= 5; i++) {

            System.out.print("Bowler " + i + " : ");

            int choice = sc.nextInt();

            if (choice < 1 || choice > 11) {
                System.out.println("Invalid choice.");
                i--;
                continue;
            }

            if (selectedBowlers2[choice - 1]) {
                System.out.println("Bowler already selected.");
                i--;
                continue;
            }

            selectedBowlers2[choice - 1] = true;

            team2.addBowler(new Bowler(team2.players.get(choice - 1).name));
        }
       
        Match match = new Match(team1, team2);

        match.toss();
        int overs;

        do {
            System.out.print("\nEnter number of overs (2 to 10): ");
            overs = sc.nextInt();

            if (overs < 2 || overs > 10) {
                System.out.println("Invalid! Please enter between 2 and 10.");
            }

        } while (overs < 2 || overs > 10);

        Innings innings = new Innings(match.battingTeam, match.bowlingTeam, overs);

        innings.startInnings();
        match.target = innings.battingTeam.totalRuns + 1;

        System.out.println();
        System.out.println("==========================================");
        System.out.println("Target : " + match.target);
        System.out.println("==========================================");

        // Swap batting and bowling teams
        Team temp = match.battingTeam;
        match.battingTeam = match.bowlingTeam;
        match.bowlingTeam = temp;

        // Start second innings
        Innings innings2 = new Innings(match.battingTeam, match.bowlingTeam, overs);
        innings2.target = match.target;

        innings2.startInnings();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           MATCH RESULT");
        System.out.println("==========================================");

        if (innings2.battingTeam.totalRuns >= match.target) {

            int wicketsLeft = 10 - innings2.battingTeam.wickets;

            System.out.println(match.battingTeam.teamName +
                    " won by " + wicketsLeft + " wickets.");

        } else {

            int runs = match.target - innings2.battingTeam.totalRuns - 1;

            System.out.println(match.bowlingTeam.teamName +
                    " won by " + runs + " runs.");
        }

        System.out.println("==========================================");

        sc.close();
    }
}