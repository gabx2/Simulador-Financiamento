package main;

import modelo.*;
import util.InterfaceUsuario;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean continuar = true;
        int contador = 1;

        System.out.println("=== SISTEMA PARA SIMULAÇÃO DE FINANCIAMENTOS ===");

        while (continuar) {
            System.out.println("\n--- Cadastro do financiamento " + contador + " ---");

            System.out.println("Escolha o tipo de financiamento:");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");
            System.out.print("Opção: ");

            int opcao = input.nextInt();

            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamentoAnos = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJuros = interfaceUsuario.pedirTaxaJurosAnual();

            Financiamento financiamento = null;

            switch(opcao) {
                case 1: // CASA
                    System.out.print("Digite o tamanho da área construída (m²): ");
                    double areaConstruida = input.nextDouble();

                    System.out.print("Digite o tamanho do terreno (m²): ");
                    double areaTerreno = input.nextDouble();

                    financiamento = new Casa(valorImovel, prazoFinanciamentoAnos, taxaJuros,
                            areaConstruida, areaTerreno);
                    break;

                case 2: // APARTAMENTO
                    System.out.print("Digite o número de vagas na garagem: ");
                    int vagas = input.nextInt();

                    System.out.print("Digite o número do andar: ");
                    int andar = input.nextInt();

                    financiamento = new Apartamento(valorImovel, prazoFinanciamentoAnos, taxaJuros,
                            vagas, andar);
                    break;

                case 3: // TERRENO
                    String tipoZona = "";
                    int escolhaZona;

                    do {
                        System.out.println("Escolha o tipo de zona do terreno:");
                        System.out.println("1 - Residencial");
                        System.out.println("2 - Comercial");
                        System.out.print("Opção: ");
                        escolhaZona = input.nextInt();

                        if (escolhaZona == 1) tipoZona = "Residencial";
                        else if (escolhaZona == 2) tipoZona = "Comercial";
                        else System.out.println("Opção inválida! Escolha 1 ou 2.\n");

                    } while (escolhaZona != 1 && escolhaZona != 2);

                    financiamento = new Terreno(valorImovel, prazoFinanciamentoAnos, taxaJuros,
                            tipoZona);
                    break;

                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            financiamentos.add(financiamento);

            String resposta;
            do {
                System.out.print("Deseja adicionar outro financiamento? (s/n): ");
                resposta = input.next().trim().toLowerCase();

                if (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Entrada inválida! Digite apenas 's' ou 'n'.");
                }

            } while (!resposta.equals("s") && !resposta.equals("n"));

            if (resposta.equals("n")) {
                continuar = false;
            } else {
                contador++;
            }
        }

        // RELATÓRIO FINAL
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("\n===== RELATÓRIO FINAL =====");

        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento f = financiamentos.get(i);

            System.out.println("\nFinanciamento " + (i + 1) + ":");

            System.out.println("Tipo: " + f.getClass().getSimpleName());
            f.mostrarDados();

            System.out.println("==================================");

            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularValorTotal();
        }

        System.out.println("\n----------------------------------");
        System.out.println("Total de todos os imóveis: R$ " + df.format(totalImoveis));
        System.out.println("Total de todos os financiamentos: R$ " + df.format(totalFinanciamentos));
        System.out.println("==================================\n");

        input.close();
    }
}
