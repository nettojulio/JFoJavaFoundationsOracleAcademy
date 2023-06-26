package br.com.julioneto.exercicio006.problemset002;

import java.util.Scanner;

public class DisplayMultiples {
    private static final Scanner keyboard = new Scanner(System.in);

    private DisplayMultiples() {
    }

    public static void calculate() {
        Integer number = null;

        while (number == null) {
            System.out.print("Insert a number: ");
            String input = keyboard.nextLine().trim();

            if (!input.isEmpty()) {
                try {
                    number = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    // NOT IMPLEMENTED
                }
            }
        }

        for (int i = 1; i <= 12; i++) {
            System.out.println(number + "x" + i + " = " + (number * i));
        }
    }
}
