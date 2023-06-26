package br.com.julioneto.exercicio008.core;

import java.util.List;
import java.util.Random;

public class Game {
    private final Team team1;
    private final Team team2;
    private final Day day;
    private int team1Score;
    private int team2Score;

    public Game(Day day, List<Team> round) {
        this.day = day;
        this.team1 = round.get(0);
        this.team2 = round.get(1);
        playGame(day, team1, team2);
        this.printStats();
    }

    private void playGame(Day day, Team team1, Team team2) {
        team1Score = generateScore(day);
        team2Score = generateScore(day);

        team1.addGoalsScored(team1Score);
        team1.addGoalsConceded(team2Score);

        team2.addGoalsScored(team2Score);
        team2.addGoalsConceded(team1Score);

        if (team1Score > team2Score) {
            team1.addWin();
            team2.addLoss();
        } else if (team1Score < team2Score) {
            team1.addLoss();
            team2.addWin();
        } else if (team1Score == team2Score) {
            team1.addDraw();
            team2.addDraw();
        }
    }

    private int generateScore(Day day) {
        Random random = new Random();
        switch (day.getAtmosphere()) {
            case NORMAL -> {
                return random.nextInt(4);
            }
            case WARM -> {
                return random.nextInt(8);
            }
            default -> {
                return 0;
            }

        }
    }

    public Day getDay() {
        return day;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void printStats() {
        System.out.println("Game: " + team1.getName() + " vs " + team2.getName());
        System.out.println("Score: " + team1Score + " - " + team2Score);
    }
}
