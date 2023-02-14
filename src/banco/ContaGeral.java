package banco;

public abstract class ContaGeral {

    /*String nomeCorrentista;
    double saldo;*/

    public abstract double consultar();
    public abstract void depositar(double valor);
    public abstract boolean sacar(double valor);
    public abstract String getNomeCorrentista();
    public abstract String toString();
    public abstract double consultarLimite();
    public abstract void alterarLimite(double limite);
}
