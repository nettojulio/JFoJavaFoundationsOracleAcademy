package br.com.julioneto.exercicio008.core;

public class Day {
    private final double temperature;
    private final Temperature atmosphere;

    public Day(double temperature) {
        this.temperature = temperature;
        this.atmosphere = Temperature.getAtmosphere(temperature);
    }

    public double getTemperature() {
        return temperature;
    }

    public Temperature getAtmosphere() {
        return atmosphere;
    }

    @Override
    public String toString() {
        return "Day{" +
                "temperature=" + temperature +
                ", atmosphere=" + atmosphere +
                '}';
    }

    public enum Temperature {
        COLD(),
        NORMAL(),
        WARM();

        public static Temperature getAtmosphere(Double temperature) {
            if (temperature <= 0.0) {
                return COLD;
            } else if (temperature > 0.0 && temperature <= 68.0) {
                return NORMAL;
            } else {
                return WARM;
            }
        }
    }
}
