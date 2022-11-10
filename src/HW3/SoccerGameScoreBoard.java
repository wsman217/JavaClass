package HW3;

import java.util.Scanner;

public class SoccerGameScoreBoard {

    private final String teamName;
    private final int goalsInMatch;
    private final int goalsInExtraTime;
    private final int goalsInPenaltyShootOut;

    private static int countTeams;

    // Initialize countTeams.
    static {
        countTeams = 0;
    }

    // Constructor to allow only the team name to be entered. And ask the user to input the other values at run time.
    public SoccerGameScoreBoard(String teamName) {
        this(teamName, getInt("goals in match"), getInt("goals in extra time"), getInt("goals in penalty shoot out"));
    }

    // Constructor that takes all the values and sets them.
    public SoccerGameScoreBoard(String teamName, int goalsInMatch, int goalsInExtraTime, int goalsInPenaltyShootOut) {
        this.teamName = teamName;
        this.goalsInMatch = goalsInMatch;
        this.goalsInExtraTime = goalsInExtraTime;
        this.goalsInPenaltyShootOut = goalsInPenaltyShootOut;

        countTeams++;
    }

    @Override
    public String toString() {
        return "SoccerGameScoreBoard [teamName=" + teamName + ", goalsInMatch=" + goalsInMatch + ", goalsInExtraTime="
                + goalsInExtraTime + ", goalsInPenaltyShootOut=" + goalsInPenaltyShootOut + "]";
    }

    // Method to ask the user for an integer value with a question attached to it.
    private static int getInt(String q) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter " + q + ": ");
        return s.nextInt();
    }

    // Getter methods.
    public String getTeamName() {
        return teamName;
    }

    public int getGoalsInMatch() {
        return goalsInMatch;
    }

    public int getGoalsInExtraTime() {
        return goalsInExtraTime;
    }

    public int getGoalsInPenaltyShootOut() {
        return goalsInPenaltyShootOut;
    }

    public static int getCountTeams() {
        return countTeams;
    }
}

