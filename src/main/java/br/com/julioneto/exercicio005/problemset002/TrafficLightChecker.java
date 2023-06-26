package br.com.julioneto.exercicio005.problemset002;

import java.util.Scanner;

public class TrafficLightChecker {
    private final int colorCode;

    public TrafficLightChecker(int colorCode) {
        this.colorCode = colorCode;
    }

    public static void execute() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a color code: ");
        TrafficLightChecker tlc = new TrafficLightChecker(keyboard.nextInt());
        System.out.println(tlc.check());
        keyboard.close();
    }

    public String check() {
        if (colorCode == 1) {
            return "Next Traffic Light is green";
        } else if (colorCode == 2) {
            return "Next Traffic Light is yellow";
        } else if (colorCode == 3) {
            return "Next Traffic Light is red";
        } else {
            return "Invalid color";
        }
    }
}
