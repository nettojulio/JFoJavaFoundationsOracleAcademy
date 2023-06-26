package br.com.julioneto.exercicio003;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio003 {
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        teclado.useLocale(Locale.US);

        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = teclado.nextInt();
        System.out.print("Digite sua altura: ");
        double altura = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("Confira os dados abaixo:");
        System.out.println("Nome: " + nome + "\nIdade: " + idade + "\nAltura: " + altura);
        System.out.print("Os dados estão corretos (SIM/NAO)? ");
        String confirma = teclado.nextLine().trim().toLowerCase();

        if ("nao".equals(confirma)) {
            throw new IllegalStateException();
        }

        Pessoa pessoa = new Pessoa(nome, idade, altura);

        pessoa.nascimento();
        pessoa.mediaAltura();
        somarDezNumeros();
        teclado.close();
    }

    public static void somarDezNumeros() {
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i + 1) + " numero: ");
            numeros.add(teclado.nextInt());
        }

        System.out.println("A Soma dos numeros é " + numeros.stream().reduce(0, Integer::sum));
    }

    record Pessoa(String nome, int idade, double altura) {
        private static final double MEDIA_ALTURA = 1.68;

        public void nascimento() {
            System.out.println("Seu nascimento foi em " + (LocalDateTime.now().getYear() - this.idade) + ", caso já tenha feito aniversário este ano.");
        }

        public void mediaAltura() {
            double saldo = this.altura - MEDIA_ALTURA;
            if (saldo != 0.0) {
                System.out.printf("Voce está %.2f %s da média nacional%n", saldo, saldo > 0.0 ? "acima" : "abaixo");
            } else {
                System.out.println("Voce está na media de altura nacional");
            }
        }
    }
}
