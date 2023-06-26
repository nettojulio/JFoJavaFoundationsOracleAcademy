package br.com.julioneto.exercicio004.problemset001;

import java.util.Random;

public class ComputeMethods {
    public double fToC(double degreesF) {
        return (5.0 / 9.0) * (degreesF - 32);
    }

    public double hypotenuse(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public int roll() {
        Random random = new Random();
        int diceA = random.nextInt(6) + 1;
        int diceB = random.nextInt(6) + 1;
        return diceA + diceB;
    }
}
