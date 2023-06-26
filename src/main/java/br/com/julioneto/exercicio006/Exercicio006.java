package br.com.julioneto.exercicio006;

import br.com.julioneto.exercicio006.problemset001.ValidatePin;
import br.com.julioneto.exercicio006.problemset002.DisplayMultiples;
import br.com.julioneto.exercicio006.problemset003.LoopShape;

public class Exercicio006 {
    public static void main(String[] args) {
        ValidatePin.validate();
        DisplayMultiples.calculate();
        LoopShape.createRectangle(3, 3);
        LoopShape.createTriangle(4);
    }
}
