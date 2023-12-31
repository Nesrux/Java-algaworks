package desafio.domain.model;

public final class Programador extends Funcionario {
    private double valorBonus;

    public Programador(String nome, double valorHora, double valorBonus) {
        super(nome, valorHora);
        this.valorBonus = valorBonus;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    @Override
    protected final double calcularSalario(int horasTrabalhadas) {
        return super.calcularSalario(horasTrabalhadas) + getValorBonus();
    }


    @Override
    public String toString() {
        return super.toString() + String.format("ValorBonus: %.2f%n", getValorBonus());

    }
}
