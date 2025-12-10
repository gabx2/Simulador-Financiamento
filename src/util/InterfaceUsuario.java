package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner input = new Scanner(System.in);

    public double pedirValorImovel() {
        double valorImovel = 0;
        boolean valido = false;

        do {
            try {
                System.out.println("Digite o valor do imóvel: ");
                valorImovel = input.nextDouble();

                if (valorImovel <= 0) {
                    System.out.println("Valor inválido! O valor do imóvel deve ser maior que zero.\n");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.\n");
                input.nextLine();
            }
        } while (!valido);

        return valorImovel;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        boolean valido = false;

        do {
            try {
                System.out.println("Digite o prazo do financiamento (em anos, entre 1 e 50): ");
                prazo = input.nextInt();

                if (prazo < 1 || prazo > 50) {
                    System.out.println("Prazo inválido! O prazo deve estar entre 1 e 50 anos.\n");
                } else {
                    valido = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!\n");
                input.nextLine();
            }
        } while (!valido);

        return prazo;
    }

    public double pedirTaxaJurosAnual() {
        double taxa = 0;
        boolean valido = false;

        do {
            try {
                System.out.println("Digite a taxa de juros anual (entre 1 e 50): ");
                taxa = input.nextDouble();

                if (taxa < 1 || taxa > 50) {
                    System.out.println("Taxa inválida!\n");
                } else {
                    valido = true;
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida!\n");
                input.nextLine();
            }
        } while (!valido);

        return taxa;
    }
}
