package br.com.julioneto.exercicio008.core;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;


public class FootballLeague {
    private final Scanner keyboard = new Scanner(System.in);
    private final Map<Integer, Game> games = new TreeMap<>();
    private final List<Day> statistics = new ArrayList<>();
    private final List<Team> teams;
    private final Rounds rounds;
    private int consecutiveFreezingWeeks = 0;
    private int currentRound = 0;

    private FootballLeague() {
        Team team1 = new Team("Team A");
        Team team2 = new Team("Team B");
        Team team3 = new Team("Team C");
        Team team4 = new Team("Team D");
        this.teams = new ArrayList<>(Arrays.asList(team1, team2, team3, team4));
        this.rounds = new Rounds(this.teams);
    }

    public static void start() {
        FootballLeague footballLeague = new FootballLeague();
        footballLeague.run();
    }

    private void run() {
        do {
            double temperature = inputTemperature();
            Day day = new Day(temperature);
            checkConsecutiveFreezingWeeks(day);
            if (day.getAtmosphere().toString().equals("COLD")) {
                System.out.println("Too cold to play");
                continue;
            }
            List<List<Team>> round = rounds.getSpecificRound(++currentRound);
            round.forEach(game -> games.putIfAbsent(games.size() + 1, new Game(day, game)));
            if (currentRound == rounds.getTotalRounds()) {
                rounds.extendRounds();
            }
        } while (consecutiveFreezingWeeks < 3);
        System.out.println("Season is over");
        System.out.println("\n\n*********RESULTS*********\n\n");
        teamsResume();
        gameResume();
        temperatureResume();
        keyboard.close();
    }


    private double inputTemperature() {
        keyboard.useLocale(Locale.US);
        Double temperature;

        do {
            System.out.print("Insert the temperature of this day (Fahrenheit): ");
            String insertValue = keyboard.nextLine().replace(",", ".");
            temperature = validateInput(insertValue);
        } while (temperature == null);

        return temperature;
    }

    private Double validateInput(String insertValue) {
        try {
            return Double.parseDouble(insertValue);
        } catch (Exception e) {
            System.out.println("Wrong temperature...");
        }
        return null;
    }

    public void checkConsecutiveFreezingWeeks(Day d) {
        if (d.getAtmosphere().toString().equals("COLD")) {
            this.consecutiveFreezingWeeks++;
        } else {
            this.consecutiveFreezingWeeks = 0;
        }
    }

    private void teamsResume() {
        teams.forEach(team -> {
            System.out.println(team.getName());
            System.out.println("Wins: " + team.getWins() + ", Losses: " + team.getLosses() + ", Ties: " + team.getDraws());
            System.out.println("Points Scored: " + team.getGoalsScored() + ", Points Allowed: " + team.getGoalsConceded());
            System.out.println();
        });
    }

    private void gameResume() {
        games.forEach((key, value) -> {
            System.out.println("Game #" + key);
            System.out.println("Temperature: " + value.getDay().getTemperature());
            System.out.println("Away Team: " + value.getTeam2().getName() + ", " + value.getTeam2Score());
            System.out.println("Home Team: " + value.getTeam1().getName() + ", " + value.getTeam1Score());
            System.out.println();
            statistics.add(value.getDay());
        });
    }

    private void temperatureResume() {
        if (statistics.isEmpty()) {
            System.out.println("No games played yet");
            return;
        }
        double hottestTemperature = statistics.stream().max(Comparator.comparingDouble(Day::getTemperature)).get().getTemperature();
        double averageTemperature = statistics.stream().mapToDouble(Day::getTemperature).average().getAsDouble();

        System.out.println("Hottest Temp: " + hottestTemperature);
        System.out.println("Average Temp: " + averageTemperature);
    }
}
