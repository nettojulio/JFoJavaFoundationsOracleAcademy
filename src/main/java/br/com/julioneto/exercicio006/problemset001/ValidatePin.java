package br.com.julioneto.exercicio006.problemset001;

import java.util.Scanner;

public class ValidatePin {
    private static final int PIN = 123456;
    private static final Scanner keyboard = new Scanner(System.in);

    private ValidatePin() {

    }

    public static void validate() {
        Integer incomingPIN = null;
        while (incomingPIN == null || PIN != incomingPIN) {
            System.out.print("Insert pin: ");
            String input = keyboard.nextLine().trim();

            if (!input.isEmpty()) {
                try {
                    incomingPIN = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    // NOT IMPLEMENTED
                }
            }
        }
        System.out.println("Correct PIN!");
    }
}
