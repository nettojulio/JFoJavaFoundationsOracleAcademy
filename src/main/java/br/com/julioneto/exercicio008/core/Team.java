package br.com.julioneto.exercicio008.core;

public class Team {
    private final String name;
    private int wins;
    private int losses;
    private int draws;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
    }

    public String getName() {
        return this.name;
    }

    public void addWin() {
        wins++;
    }

    public void addLoss() {
        losses++;
    }

    public void addDraw() {
        draws++;
    }

    public void addGoalsScored(int goals) {
        goalsScored += goals;
    }

    public void addGoalsConceded(int goals) {
        goalsConceded += goals;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void printStats() {
        System.out.println("Team: " + name);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Goals scored: " + goalsScored);
        System.out.println("Goals conceded: " + goalsConceded);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                '}';
    }
}
