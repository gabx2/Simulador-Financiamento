package modelo;

public class Apartamento extends Financiamento {

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazo, double taxa, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazo, taxa);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularValorMensal() {
        double i = (this.taxaJurosAnual / 100) / 12;
        int n = this.prazoFinanciamento * 12;

        return this.valorImovel * (i * Math.pow(1 + i, n)) /
                (Math.pow(1 + i, n) - 1);
    }

    @Override
    public double calcularValorTotal() {
        return calcularValorMensal() * prazoFinanciamento * 12;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Vagas na garagem: " + vagasGaragem);
        System.out.println("Número do andar: " + numeroAndar);
        System.out.println("Valor total do financiamento: R$ " + this.calcularValorTotal());
    }
}
