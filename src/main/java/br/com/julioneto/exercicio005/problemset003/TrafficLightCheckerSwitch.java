package br.com.julioneto.exercicio005.problemset003;

import java.util.Scanner;

public class TrafficLightCheckerSwitch {
    private final int colorCode;

    public TrafficLightCheckerSwitch(int colorCode) {
        this.colorCode = colorCode;
    }

    public static void execute() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a color code: ");
        TrafficLightCheckerSwitch tlc = new TrafficLightCheckerSwitch(keyboard.nextInt());
        System.out.println(tlc.check());
        keyboard.close();
    }

    public String check() {
        return switch (colorCode) {
            case 1 -> "Next Traffic Light is green";
            case 2 -> "Next Traffic Light is yellow";
            case 3 -> "Next Traffic Light is red";
            default -> "Invalid color";
        };
    }
}
