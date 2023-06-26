package br.com.julioneto.exercicio007;

import br.com.julioneto.exercicio007.core.Card;
import br.com.julioneto.exercicio007.core.Game;
import br.com.julioneto.exercicio007.core.Terminal;

import java.util.Random;

public class Exercicio007 {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();

        Card card1 = new Card();
        Card card2 = new Card();

        Game game1 = new Game("Super Mario Game", 2);
        Game game2 = new Game("Sonic 3", 3);
        Game game3 = new Game("Pac man", 1);
        Game game4 = new Game("FInal Fight 3", 5);
        Game game5 = new Game("Super Street Fighter 6", 10);

        terminal.addCredits(card1, new Random().nextInt(30) + 1);
        terminal.addCredits(card2, new Random().nextInt(40) + 1);

        game1.play(card1);
        game3.play(card2);
        game2.play(card1);
        game4.play(card2);

        terminal.creditsTransferBalance(card1, card2, terminal.getCredits(card1));
        terminal.ticketsTransferBalance(card1, card2, terminal.getTickets(card1));

        terminal.getAward(0, card2);
        terminal.getAward(1, card2);
        terminal.getAward(2, card2);
        terminal.getAward(0, card2);
        terminal.getAward(0, card2);
        terminal.getAward(0, card2);
        terminal.getAward(0, card2);
        terminal.getAward(0, card2);

        game5.play(card1);

        terminal.printBalances(card1);
        terminal.printBalances(card2);
    }
}
