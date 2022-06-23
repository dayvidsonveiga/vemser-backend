public interface Movimentacao {
    public abstract Boolean sacar(double valor);
    public abstract Boolean depositar(double valor);
    public abstract Boolean transferir(Conta conta, double valor);
}
