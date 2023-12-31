package list.arrayList;

import java.util.Comparator;
import java.util.Objects;

public class Hotel implements Comparable<Hotel> {
    private String nome;
    private String cidade;
    private double precoDiaria;

    public Hotel(String nome, String cidade, double precoDiaria) {
        setNome(nome);
        setCidade(cidade);
        setPrecoDiaria(precoDiaria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome);
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        if (precoDiaria < 0) {
            throw new IllegalArgumentException("Preço da diária não pode ser negativo");
        }

        this.precoDiaria = precoDiaria;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", precoDiaria=" + precoDiaria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        return nome.equals(hotel.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public int compareTo(Hotel o) {
        //A boa pratica é implementar o comparable utilizando
        //as propriedades que são feitos para definir o equals e hashcode
        // que nesse caso é o nome!
        return this.nome.compareTo(o.getNome());

/*
        return Double.compare(this.precoDiaria, o.getPrecoDiaria());
        if (this.getPrecoDiaria() > o.getPrecoDiaria()) {
            return 1;
        } else if (this.getPrecoDiaria() < o.getPrecoDiaria()) {
            return -1;
        }
        return 0;
        */

    }

    public static class PrecoHotelComparator implements Comparator<Hotel> {
        @Override
        public int compare(Hotel o1, Hotel o2) {
            return Double.compare(o1.precoDiaria, o2.getPrecoDiaria());
        }
    }
}
