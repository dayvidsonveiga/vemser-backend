package homework1;

import entities.ContaCorrente;
import entities.ContaPagamento;
import entities.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    //CONTA CORRENTE

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        //setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000.00);
        contaCorrente.setChequeEspecial(1000.00);
        double saque = 1500.00;

        //act
        boolean conseguiuSacar = contaCorrente.sacar(saque);


        //assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(-500, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        //setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000.00);
        contaCorrente.setChequeEspecial(1000.00);
        double valorSaque = 3000.00;

        //act
        boolean conseguiuSacar = contaCorrente.sacar(valorSaque);

        //assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        //setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000.00);
        contaPoupanca.creditarTaxa();
        double valorSaque = 900.00;

        //act
        boolean conseguiuSacar = contaPoupanca.sacar(valorSaque);

        //assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(110.00, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        //setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000.00);
        double valorSaque = 1100.00 ;

        //act
        boolean conseguiuSacar = contaPoupanca.sacar(valorSaque);

        //assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000.00, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        //setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000.00);
        double valorSaque = 995.75;

        //act
        boolean conseguiuSacar = contaPagamento.sacar(valorSaque);

        //assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(0.0, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        //setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000.00);
        double valorSaque = 1500.00;

        //act
        boolean conseguiuSacar = contaPagamento.sacar(valorSaque);

        //assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000.00, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        //setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000.00);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(300.00);

        //act
        boolean conseguiuTransferir = contaPagamento.transferir(contaPoupanca, 500.00);

        //assert
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(500.00, contaPagamento.getSaldo());
        Assertions.assertEquals(800.00, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        //setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000.00);
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(0.0);
        double transferencia = 1500.00;

        //act
        boolean conseguiuTransferir = contaPagamento.transferir(contaPoupanca, transferencia);

        //assert
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(1000.00, contaPagamento.getSaldo());
        Assertions.assertEquals(0.0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {
        //setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000.00);

        double deposito = 1500.00;

        //act
        boolean conseguiuDepositar = contaPagamento.depositar(deposito);

        //assert
        Assertions.assertTrue(conseguiuDepositar);
        Assertions.assertEquals(2500.00, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativo() {
        //setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000.00);
        double deposito = -1500.00;
        double depositoZerado = 0.0;

        //act
        boolean conseguiuDepositar = contaPagamento.depositar(deposito);
        conseguiuDepositar = contaPagamento.depositar(depositoZerado);

        //assert
        Assertions.assertFalse(conseguiuDepositar);
        Assertions.assertEquals(1000.00, contaPagamento.getSaldo());
    }
}
