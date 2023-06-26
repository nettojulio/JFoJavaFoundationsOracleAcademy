package br.com.julioneto.exercicio007.core;

public class AwardsCatalog {
    private String name;
    private int ticketsRequired;
    private int remaining;

    public AwardsCatalog(String name, int ticketsRequired, int remaining) {
        if (ticketsRequired < 0 || remaining < 0) {
            System.out.println("Invalid input!");
            return;
        }
        this.name = name;
        this.ticketsRequired = ticketsRequired;
        this.remaining = remaining;
    }

    void award(Card card) {
        if (card.getTickets() < ticketsRequired) {
            System.out.println("Insufficient tickets.");
            return;
        }
        if (remaining == 0) {
            System.out.println("insufficient stock! Try another award");
            return;
        }
        System.out.println("You won a " + name + "!");
        card.addTickets(card.getTickets() - ticketsRequired);
        remaining--;
        System.out.println("Remaining: " + remaining);
    }
}
