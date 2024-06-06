public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Julia", "12278294938");

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        Banco banco = new Banco();
        banco.addConta(cc);
        banco.addConta(cp);

        cc.imprimirExtrato();

        cc.depositar(100);
        cc.transferir(10, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        banco.listarContas();
        banco.listarClientes();
    }
}
