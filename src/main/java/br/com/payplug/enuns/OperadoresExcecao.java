package br.com.payplug.enuns;

/**
 *
 * @author jsoliveira
 */
public enum OperadoresExcecao {

    maior(1),menor(2),igual(3),diferente(4);

    private final Integer operador;

    private OperadoresExcecao(Integer operador) {
        this.operador = operador;
    }

    public Integer getOperador() {
        return operador;
    }

}
