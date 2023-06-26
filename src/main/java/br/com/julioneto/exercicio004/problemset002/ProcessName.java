package br.com.julioneto.exercicio004.problemset002;

public class ProcessName {
    private final String name;

    public ProcessName(String name) {
        this.name = name;
    }

    public String presentation() {
        String[] splitName = this.name.split(" ");
        return "Your name is: " + splitName[splitName.length - 1] + ", " + splitName[0].charAt(0) + ".";
    }
}
