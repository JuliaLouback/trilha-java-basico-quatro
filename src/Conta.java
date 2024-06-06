import java.util.Objects;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfos() {
        System.out.printf("Agencia: %d %n", this.agencia);
        System.out.printf("Numero: %d %n", this.numero);
        System.out.printf("Saldo: %.2f %n", this.saldo);
        System.out.printf("Titular: %s %n", this.cliente.getNome());
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public String toString() {
        return "--- Conta --- " +
                "Agencia = " + agencia +
                "\tNumero = " + numero +
                "\tSaldo = " + saldo +
                "\tCliente = " + cliente.getNome() +
                " -- CPF = " + cliente.getCpf();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia == conta.agencia && numero == conta.numero && Double.compare(saldo, conta.saldo) == 0 && Objects.equals(cliente, conta.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero, saldo, cliente);
    }
}
