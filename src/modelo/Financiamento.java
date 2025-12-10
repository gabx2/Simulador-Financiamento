package modelo;

public abstract class Financiamento {

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularValorMensal();
    public abstract double calcularValorTotal();

    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public void mostrarDados() {
        System.out.println("\n===== SIMULAÇÃO DO FINANCIAMENTO =====");
        System.out.println("Valor do imóvel: R$ " + this.valorImovel);
        System.out.println("Prazo (anos): " + this.prazoFinanciamento);
        System.out.println("Taxa de juros anual: " + this.taxaJurosAnual + "%");
    }
}
