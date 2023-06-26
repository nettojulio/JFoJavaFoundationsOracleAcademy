package br.com.julioneto.exercicio005.problemset001;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ColorRange {
    private final Color color;

    public ColorRange(double waveLength) {
        this.color = Color.defineColor(waveLength);
    }

    public static void execute() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a color code: ");
        ColorRange cr = new ColorRange(keyboard.nextDouble());
        System.out.println(cr.display());
        keyboard.close();
    }

    public String display() {
        return color != null ? "The color is " + color : "The entered wavelength is not a part of the visible spectrum";
    }

    enum Color {
        VIOLET(380, 450),
        BLUE(450, 495),
        GREEN(495, 570),
        YELLOW(570, 590),
        ORANGE(590, 620),
        RED(620, 750);

        private final double START;
        private final double END;

        Color(double start, double end) {
            this.START = start;
            this.END = end;
        }

        public static Color defineColor(double waveLength) {
            List<Color> colors = Arrays.stream(Color.values()).toList();
            Color color = null;
            for (Color currentColor : colors) {
                if (waveLength >= currentColor.START && waveLength <= currentColor.END) {
                    color = currentColor;
                    break;
                }
            }
            return color;
        }
    }
}
