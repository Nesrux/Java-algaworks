package com.nesrux.financeira.modelo;

import com.nesrux.financeira.interfaces.ClienteFinanciavel;

public class Funcionario implements ClienteFinanciavel {
    public static final int LIMITE_CREDITO_SALARIO = 5;

    private String nome;
    private double salarioMensal;

    public Funcionario(String nome, double salarioMensal) {
        this.nome = nome;
        this.salarioMensal = salarioMensal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularLimiteAprovado() {
        return getSalarioMensal() * LIMITE_CREDITO_SALARIO;
    }
}