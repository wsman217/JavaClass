package HW3;

public class DisplaySoccerGameResults {
    public static void main(String[] args) {
        // Create 2 teams and compare and print them using the SoccerGameResults class.
        SoccerGameScoreBoard machesterUnited = new SoccerGameScoreBoard("Machester United", 3, 1, 5);
        SoccerGameScoreBoard liverpool = new SoccerGameScoreBoard("Liverpool", 3, 1, 4);
        SoccerGameResults results = new SoccerGameResults(machesterUnited, liverpool);
        SoccerGameResults.printResults(results);

        // Create 2 new teams and compare and print them using the SoccerGameResults class.
        SoccerGameScoreBoard team1 = new SoccerGameScoreBoard("Team1");
        SoccerGameScoreBoard team2 = new SoccerGameScoreBoard("Team2");
        SoccerGameResults results1 = new SoccerGameResults(team1, team2);
        SoccerGameResults.printResults(results1);

        //Print the total teams created.
        System.out.println("Total teams created: " + SoccerGameScoreBoard.getCountTeams());
    }
}