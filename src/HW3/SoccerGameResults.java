package HW3;

public class SoccerGameResults {
    private final SoccerGameScoreBoard team1;
    private final SoccerGameScoreBoard team2;
    private String winnerTeam;
    private String loserTeam;
    private boolean isTie = false;
    private WinType winType;

    // Main function that acts as driver code to determine which team won.
    public SoccerGameResults(SoccerGameScoreBoard team1, SoccerGameScoreBoard team2) {
        this.team1 = team1;
        this.team2 = team2;

        // First check if the goals equal each other which signifies a possible tie.
        if (team1.getGoalsInMatch() == team2.getGoalsInMatch())
            this.isTie = true;

        // Check if one teams total goals was greater than the other teams total goals.
        if (team1.getGoalsInMatch() + team1.getGoalsInExtraTime() >
                team2.getGoalsInMatch() + team2.getGoalsInExtraTime()) {
            // If it was a tie then that means there were goals in extra time.
            if (isTie)
                this.winType = WinType.EXTRA_TIME;
            else
                this.winType = WinType.FLAT_WIN;
            setWinner(true);
            // Change isTie to false since it has not ended in a tie.
            this.isTie = false;
        } else if (team1.getGoalsInMatch() + team2.getGoalsInExtraTime() <
                team2.getGoalsInMatch() + team2.getGoalsInExtraTime()) {
            if (isTie)
                this.winType = WinType.EXTRA_TIME;
            else
                this.winType = WinType.FLAT_WIN;
            setWinner(false);
            this.isTie = false;
        }

        // Check if penalty shootout was greater.
        if (team1.getGoalsInPenaltyShootOut() > team2.getGoalsInPenaltyShootOut()) {
            this.winType = WinType.PENALTY_SHOOTOUT;
            setWinner(true);
            this.isTie = false;
        } else if (team1.getGoalsInPenaltyShootOut() < team2.getGoalsInPenaltyShootOut()) {
            this.winType = WinType.PENALTY_SHOOTOUT;
            setWinner(false);
            this.isTie = false;
        }
    }

    // Code to print the result of the game.
    public static void printResults(SoccerGameResults results) {
        if (!results.isTie())
            System.out.println(results.getWinnerTeam() + " vs " + results.getLoserTeam() +
                    " the winner is " + results.getWinnerTeam() + " " + results.getWinType() +
                    ".");
        else
            System.out.println(results.team1.getTeamName() + " vs " +
                    results.team2.getTeamName() + " has ended in a tie.");
    }

    // Getter methods.
    public String getWinnerTeam() {
        return winnerTeam;
    }

    public String getLoserTeam() {
        return loserTeam;
    }

    public boolean isTie() {
        return isTie;
    }

    public WinType getWinType() {
        return winType;
    }

    /**
     * Set who won the match.
     *
     * @param wasTeam1 true for team 1 false for team 2
     */
    private void setWinner(boolean wasTeam1) {
        if (wasTeam1) {
            this.winnerTeam = team1.getTeamName();
            this.loserTeam = team2.getTeamName();
        } else {
            this.winnerTeam = team2.getTeamName();
            this.loserTeam = team1.getTeamName();
        }
    }

    // The different win types.
    private enum WinType {
        // Win via points during the game.
        FLAT_WIN() {
            @Override
            public String toString() {
                return "";
            }
        },
        // Win via points during extra time. Signifies that points during game was a tie.
        EXTRA_TIME() {
            @Override
            public String toString() {
                return "via extra time";
            }
        },
        // Win via points in a penalty shootout.
        PENALTY_SHOOTOUT() {
            @Override
            public String toString() {
                return "via penalty shootout";
            }
        }
    }
}