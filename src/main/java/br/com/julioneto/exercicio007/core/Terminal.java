package br.com.julioneto.exercicio007.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Terminal {
    private final List<AwardsCatalog> awardsCatalog = new ArrayList<>();

    public Terminal() {
        for (int i = 1; i <= 3; i++) {
            awardsCatalog.add(new AwardsCatalog("Awards " + (i), new Random().nextInt(10) + 1, new Random().nextInt(10) + 1));
        }
    }

    public void addCredits(Card card, int money) {
        card.addCredits(card.getCredits() + (money * 2));
    }

    public int getCredits(Card card) {
        return card.getCredits();
    }

    public int getTickets(Card card) {
        return card.getTickets();
    }

    public void getAward(int awardCatalogChoose, Card card) {
        awardsCatalog.get(awardCatalogChoose).award(card);
    }

    public void printBalances(Card card) {
        System.out.println("Card ID: " + card.getId() + ", Credits: " + card.getCredits() + ", Tickets: " + card.getTickets());
    }

    public void creditsTransferBalance(Card fromCard, Card toCard, int amountToTransfer) {
        if (amountToTransfer < 0) {
            System.out.println("Wrong value.");
            return;
        }
        if (fromCard.getCredits() < amountToTransfer) {
            System.out.println("Insufficient credits.");
            return;
        }
        fromCard.addCredits(fromCard.getCredits() - amountToTransfer);
        toCard.addCredits(toCard.getCredits() + amountToTransfer);
        System.out.println("Transferred " + amountToTransfer + " credits from Card " + fromCard.getId() + " to Card " + toCard.getId());
        printBalances(fromCard);
        printBalances(toCard);
    }

    public void ticketsTransferBalance(Card fromCard, Card toCard, int amountToTransfer) {
        if (amountToTransfer < 0) {
            System.out.println("Wrong value.");
            return;
        }
        if (fromCard.getTickets() < amountToTransfer) {
            System.out.println("Insufficient tickets.");
            return;
        }
        fromCard.addTickets(fromCard.getTickets() - amountToTransfer);
        toCard.addTickets(toCard.getTickets() + amountToTransfer);
        System.out.println("Transferred " + amountToTransfer + " tickets from Card " + fromCard.getId() + " to Card " + toCard.getId());
        printBalances(fromCard);
        printBalances(toCard);
    }
}
