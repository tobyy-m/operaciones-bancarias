package ar.edu.unahur.obj2.banco.cuentasBancarias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.banco.Cuentas.Cuenta;
import ar.edu.unahur.obj2.banco.comandos.DepositarComando;
import ar.edu.unahur.obj2.banco.comandos.IComando;
import ar.edu.unahur.obj2.banco.comandos.Invoker;
import ar.edu.unahur.obj2.banco.comandos.RetirarComando;

public class CuentaTest {

    @Test
    void dadaUnaCuentaConSaldoInicial10000_alDepositar50000_entoncesElSaldoEs15000(){
        Cuenta cuenta = new Cuenta(1234, 10000.0);
        IComando deposito = new DepositarComando(cuenta, 5000.0);

        deposito.ejecutar();
        assertEquals(15000.0, cuenta.getSaldo());
    }
    
    @Test
    void cuantaConSaldo10000RealizaDeposito2000Extraccion1000Deposito3000Extrae5000ElSaldoEs9000(){
        Cuenta cuenta2 = new Cuenta(12, 10000.0);
        IComando deposito1 = new DepositarComando(cuenta2, 2000.0);
        IComando extraccion1 = new RetirarComando(cuenta2, 1000.0);
        IComando deposito2 = new DepositarComando(cuenta2, 3000.0);
        IComando extraccion2 = new RetirarComando(cuenta2, 5000.0);
        Invoker lote = new Invoker();
        lote.agregarOperacion(deposito1);
        lote.agregarOperacion(extraccion1);
        lote.agregarOperacion(deposito2);
        lote.agregarOperacion(extraccion2);
        lote.ejecutarLote();
        assertEquals(9000.0, cuenta2.getSaldo());
    }

    @Test 
    void cuantaConSaldo10000RealizaDeposito2000Extraccion1000Deposito3000Extrae5000YLuegoSeRevierte(){
        Cuenta cuenta2 = new Cuenta(12, 10000.0);
        IComando deposito1 = new DepositarComando(cuenta2, 2000.0);
        IComando extraccion1 = new RetirarComando(cuenta2, 1000.0);
        IComando deposito2 = new DepositarComando(cuenta2, 3000.0);
        IComando extraccion2 = new RetirarComando(cuenta2, 5000.0);
        Invoker lote = new Invoker();
        lote.agregarOperacion(deposito1);
        lote.agregarOperacion(extraccion1);
        lote.agregarOperacion(deposito2);
        lote.agregarOperacion(extraccion2);
        lote.ejecutarLote();
        lote.revertirUltimaEjecucion();
        assertEquals(10000.0, cuenta2.getSaldo());
    }
}