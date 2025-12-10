package modelo;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazo, double taxa, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazo, taxa);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularValorMensal() {
        double i = (this.taxaJurosAnual / 100) / 12;
        int n = this.prazoFinanciamento * 12;

        double valorBase = this.valorImovel * (i * Math.pow(1 + i, n)) /
                (Math.pow(1 + i, n) - 1);

        // amortização aproximada
        double amortizacaoMensal = this.valorImovel / n;

        // juros mensal aproximado
        double jurosMensal = valorBase - amortizacaoMensal;

        // REGRA DO EXERCÍCIO: aumento de R$ 80
        if (80 > (jurosMensal / 2)) {
            try {
                throw new AumentoMaiorDoQueJurosException(
                        "O acréscimo de R$80 é maior do que a metade dos juros da mensalidade!"
                );
            } catch (AumentoMaiorDoQueJurosException e) {
                System.out.println("EXCEÇÃO: " + e.getMessage());
            }
        }

        return valorBase + 80; // parcela normal + acréscimo exigido
    }

    @Override
    public double calcularValorTotal() {
        return calcularValorMensal() * prazoFinanciamento * 12;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Área construída: " + areaConstruida + " m²");
        System.out.println("Área do terreno: " + areaTerreno + " m²");
        System.out.println("Valor total do financiamento: R$ " + this.calcularValorTotal());
    }
}
