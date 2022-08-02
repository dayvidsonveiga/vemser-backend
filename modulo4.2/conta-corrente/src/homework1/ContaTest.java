package homework1;

import entities.ContaCorrente;
import entities.ContaPagamento;
import entities.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    //CONTA CORRENTE

    @Test
    public void saqueContaCorrente() {
        ContaCorrente contaCorrente = criarContaCorrente();

        boolean saque = contaCorrente.sacar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1500.0, contaCorrente.getSaldo());
    }

    @Test
    public void saqueContaCorrenteSemSaldo() {
        ContaCorrente contaCorrente = criarContaCorrente();

        boolean saque = contaCorrente.sacar(5000);

        Assertions.assertFalse(saque);
    }

    @Test
    public void transferenciaContaCorrente() {
        ContaCorrente contaCorrente = criarContaCorrente();
        ContaPoupanca contaPoupanca = criarContaPoupanca();

        boolean transferencia = contaCorrente.transferir(contaPoupanca, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaCorrente.getSaldo());
        Assertions.assertEquals(2500.0, contaPoupanca.getSaldo());
    }

    @Test
    public void transferenciaContaCorrenteSemSaldo() {
        ContaCorrente contaCorrente = criarContaCorrente();
        ContaPoupanca contaPoupanca = criarContaPoupanca();

        boolean transferencia = contaCorrente.transferir(contaPoupanca, 5000.0);

        Assertions.assertFalse(transferencia);
    }

    @Test
    public void depositoContaCorrente() {
        ContaCorrente contaCorrente = criarContaCorrente();

        boolean saque = contaCorrente.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaCorrente.getSaldo());
    }

    @Test
    public void depositoContaCorrenteSaldoNegativo() {
        ContaCorrente contaCorrente = criarContaCorrente();

        boolean saque = contaCorrente.depositar(-300);

        Assertions.assertFalse(saque);
    }


    //CONTA POUPANÇA


    @Test
    public void saqueContaPoupanca() {
        ContaPoupanca contaPoupanca = criarContaPoupanca();
        contaPoupanca.creditarTaxa();

        boolean saque = contaPoupanca.sacar(100.0);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1920.0, contaPoupanca.getSaldo());
    }

    @Test
    public void saqueContaPoupancaSemSaldo() {
        ContaPoupanca contaPoupanca = criarContaPoupanca();

        boolean saque = contaPoupanca.sacar(3000);

        Assertions.assertFalse(saque);
    }

    @Test
    public void transferenciaContaPoupanca() {
        ContaPoupanca contaPoupanca = criarContaPoupanca();
        ContaPagamento contaPagamento = criarContaPagamento();

        boolean transferencia = contaPoupanca.transferir(contaPagamento, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaPoupanca.getSaldo());
        Assertions.assertEquals(2500.0, contaPagamento.getSaldo());
    }

    @Test
    public void transferenciaContaPoupancaSemSaldo() {
        ContaPoupanca contaPoupanca = criarContaPoupanca();
        ContaPagamento contaPagamento = criarContaPagamento();

        boolean transferencia = contaPoupanca.transferir(contaPagamento, 5000.0);

        Assertions.assertFalse(transferencia);
    }

    @Test
    public void depositoContaPoupanca() {
        ContaPoupanca contaPoupanca = criarContaPoupanca();

        boolean saque = contaPoupanca.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaPoupanca.getSaldo());
    }

    @Test
    public void depositoContaPoupancaSaldoNegativo() {
        ContaPoupanca contaPoupanca = criarContaPoupanca();

        boolean saque = contaPoupanca.depositar(-300);

        Assertions.assertFalse(saque);
    }


    //CONTA PAGAMENTO


    @Test
    public void saqueContaPagamento() {
        ContaPagamento contaPagamento = criarContaPagamento();

        boolean saque = contaPagamento.sacar(100.0);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(1895.75, contaPagamento.getSaldo());
    }

    @Test
    public void saqueContaPagamentoSemSaldo() {
        ContaPagamento contaPagamento = criarContaPagamento();

        boolean saque = contaPagamento.sacar(3000);

        Assertions.assertFalse(saque);
    }

    @Test
    public void transferenciaContaPagamento() {
        ContaPagamento contaPagamento = criarContaPagamento();
        ContaCorrente contaCorrente = criarContaCorrente();

        boolean transferencia = contaPagamento.transferir(contaCorrente, 500.0);

        Assertions.assertTrue(transferencia);
        Assertions.assertEquals(1500.0, contaPagamento.getSaldo());
        Assertions.assertEquals(2500.0, contaCorrente.getSaldo());
    }

    @Test
    public void transferenciaContaPagamentoSemSaldo() {
        ContaPagamento contaPagamento = criarContaPagamento();
        ContaCorrente contaCorrente = criarContaCorrente();

        boolean transferencia = contaPagamento.transferir(contaCorrente, 5000.0);

        Assertions.assertFalse(transferencia);
    }

    @Test
    public void depositoContaPagamento() {
        ContaPagamento contaPagamento = criarContaPagamento();

        boolean saque = contaPagamento.depositar(500);

        Assertions.assertTrue(saque);
        Assertions.assertEquals(2500.0, contaPagamento.getSaldo());
    }

    @Test
    public void depositoContaPagamentoSaldoNegativo() {
        ContaPagamento contaPagamento = criarContaPagamento();

        boolean saque = contaPagamento.depositar(-300);

        Assertions.assertFalse(saque);
        Assertions.assertEquals(2000.0, contaPagamento.getSaldo());
    }

    //util

    public ContaCorrente criarContaCorrente(){
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setChequeEspecial(1000.0);
        contaCorrente.setSaldo(2000.0);
        return contaCorrente;
    }

    public ContaPoupanca criarContaPoupanca(){
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(2000.0);
        return contaPoupanca;
    }

    public ContaPagamento criarContaPagamento(){
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(2000.0);
        return contaPagamento;
    }
}
