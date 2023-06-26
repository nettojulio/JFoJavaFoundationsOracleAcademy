package br.com.julioneto.exercicio007.core;

import java.util.Random;

public class Game {
    private final String title;
    private final int cost;

    public Game(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public void play(Card card) {
        System.out.println("Game: " + title + ", Cost: " + cost);
        if (card.getCredits() < cost) {
            System.out.println("Insufficient credits.");
            return;
        }
        card.addCredits(card.getCredits() - cost);
        int ticketsWon = new Random().nextInt(10) + 1;
        card.addTickets(card.getTickets() + ticketsWon);
        System.out.println("Card ID: " + card.getId() + ". You won " + ticketsWon + " tickets! You have " + card.getTickets() + " tickets now!");
    }

}
