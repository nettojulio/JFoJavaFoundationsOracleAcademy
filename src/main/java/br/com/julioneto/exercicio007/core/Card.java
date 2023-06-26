package br.com.julioneto.exercicio007.core;

import java.util.UUID;

public class Card {
    private final UUID id;
    private int credits;
    private int tickets;

    public Card() {
        this.id = UUID.randomUUID();
        this.credits = 0;
        this.tickets = 0;
    }

    public UUID getId() {
        return id;
    }

    int getCredits() {
        return credits;
    }

    void addCredits(int credits) {
        this.credits = credits;
    }

    int getTickets() {
        return tickets;
    }

    void addTickets(int tickets) {
        this.tickets = tickets;
    }
}
