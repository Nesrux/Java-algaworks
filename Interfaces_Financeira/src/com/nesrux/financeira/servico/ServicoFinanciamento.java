package com.nesrux.financeira.servico;

import com.nesrux.financeira.interfaces.ClienteFinanciavel;

public class ServicoFinanciamento {

    public void solicitarFinanciamento(ClienteFinanciavel clienteFinanciavel, double valorSolicitado) {
        double limiteAprovado = clienteFinanciavel.calcularLimiteAprovado();

        double jurosCalculado = clienteFinanciavel.calcularTaxaDeJuros(valorSolicitado);

        if (limiteAprovado < valorSolicitado) {
            throw new RuntimeException(String.format(
                    "Financiamento não aprovado. Limite máximo de %.2f", limiteAprovado));
        }

        // registraríamos a solicitação do financiamento aqui em alguma classe de persistência de dados,
        // mas por enquanto, apenas imagine isso acontecendo...
        System.out.printf("DEBUG: Financiamento aprovado no valor de R$%.2f. com o  juros de %.2f Limite máximo de %.2f%n",
                valorSolicitado, jurosCalculado, limiteAprovado);
    }

    public double consultarLimiteAprovado(ClienteFinanciavel clienteFinanciavel) {
        // aqui poderia registrar a consulta em algum lugar para um consultor comercial entrar em contato
        // com o cliente (não vamos fazer isso, porque o objetivo agora é estudar OO primeiro)

        return clienteFinanciavel.calcularLimiteAprovado();
    }
}
