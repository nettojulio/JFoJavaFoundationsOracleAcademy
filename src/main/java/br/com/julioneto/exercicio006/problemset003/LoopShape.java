package br.com.julioneto.exercicio006.problemset003;

public class LoopShape {

    private LoopShape() {

    }

    public static void createRectangle(int width, int height) {
        if (width < 2 || height < 2) {
            throw new IllegalArgumentException("width and height must be greater than 2");
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void createTriangle(int leg) {
        for (int i = 0; i < leg; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == leg - 1 || j == 0 || j == i) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
