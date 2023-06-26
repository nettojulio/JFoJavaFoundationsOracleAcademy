package br.com.julioneto.exercicio008.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rounds {
    private final Map<Integer, List<Team>> table;
    private Map<Integer, List<List<Team>>> rounds;

    public Rounds(List<Team> teams) {
        this.table = generateTable(teams);
        this.rounds = new TreeMap<>();
        this.rounds = generateRounds(table);
    }

    private Map<Integer, List<List<Team>>> generateRounds(Map<Integer, List<Team>> table) {
        int splitter = table.size() / 2;
        List<List<Team>> groupA = new ArrayList<>();
        List<List<Team>> groupB = new ArrayList<>();

        for (int i = 0; i < splitter; i++) {
            groupA.add(table.get(i + 1));
            groupB.add(table.get(i + 1 + splitter));
        }

        for (int i = 0; i < splitter; i++) {
            for (int j = i + 1; j < splitter; j++) {
                List<List<Team>> round = new ArrayList<>();
                List<Team> teamA = groupA.get(i);
                List<Team> teamB = groupA.get(j);
                if (teamA.contains(teamB.get(0)) || teamA.contains(teamB.get(1))) {
                    continue;
                }
                round.add(teamA);
                round.add(teamB);
                rounds.putIfAbsent(rounds.size() + 1, round);
            }

            for (int j = i + 1; j < splitter; j++) {
                List<List<Team>> round = new ArrayList<>();
                List<Team> teamA = groupB.get(i);
                List<Team> teamB = groupB.get(j);
                if (teamA.contains(teamB.get(0)) || teamA.contains(teamB.get(1))) {
                    continue;
                }
                round.add(teamA);
                round.add(teamB);
                rounds.putIfAbsent(rounds.size() + 1, round);
            }
        }
        return rounds;
    }

    private Map<Integer, List<Team>> generateTable(List<Team> teams) {
        Map<Integer, List<Team>> table = new TreeMap<>();

        for (int i = 0; i < teams.size() - 1; i++) {
            Team teamA = teams.get(i);
            for (int j = i + 1; j < teams.size(); j++) {
                List<Team> players = new ArrayList<>();
                Team teamB = teams.get(j);
                players.add(teamA);
                players.add(teamB);
                table.put(table.size() + 1, players);
            }
        }

        for (int i = 0; i < teams.size() - 1; i++) {
            Team teamA = teams.get(i);
            for (int j = i + 1; j < teams.size(); j++) {
                Team teamB = teams.get(j);
                List<Team> players = new ArrayList<>();
                players.add(teamB);
                players.add(teamA);
                table.put(table.size() + 1, players);
            }
        }

        return table;
    }

    public List<List<Team>> getSpecificRound(int id) {
        return rounds.get(id);
    }

    public int getTotalRounds() {
        return rounds.size();
    }

    public void extendRounds() {
        generateRounds(this.table);
    }

    @Override
    public String toString() {
        return "Rounds{" +
                "round=" + rounds +
                '}';
    }
}
