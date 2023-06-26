package br.com.julioneto.exercicio004;

import br.com.julioneto.exercicio004.problemset001.ComputeMethods;
import br.com.julioneto.exercicio004.problemset002.ProcessName;

public class Exercicio004 {
    public static void main(String[] args) {
        ComputeMethods cm = new ComputeMethods();
        System.out.printf("Temp in celsius is %f%n", cm.fToC(86));
        System.out.printf("Hypotenuse is %f%n", cm.hypotenuse(4, 3));
        System.out.printf("The sum of the dice values is %d%n", cm.roll());

        // Second

        ProcessName pn = new ProcessName("Jenny Weaver");
        System.out.println(pn.presentation());
    }
}
