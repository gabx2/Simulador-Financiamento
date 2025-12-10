package modelo;

public class Terreno extends Financiamento {

    private String tipoZona;

    public Terreno(double valorImovel, int prazo, double taxa, String tipoZona) {
        super(valorImovel, prazo, taxa);
        this.tipoZona = tipoZona;
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
        System.out.println("Tipo de zona: " + tipoZona);
        System.out.println("Valor total do financiamento: R$ " + this.calcularValorTotal());
    }
}
