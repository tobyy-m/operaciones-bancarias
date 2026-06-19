package ar.edu.unahur.obj2.banco.observadores;

import ar.edu.unahur.obj2.banco.Cuentas.Cuenta;
import ar.edu.unahur.obj2.banco.operaciones.IOperacion;

public class AlertasSaldoNegativoObserver implements IObservadorCuenta{

    @Override
    public void notificar(Cuenta cuenta, IOperacion operacion, Double monto) {
        if(cuenta.getSaldo() < 0){
            System.out.println(
                "[Alerta Saldo Negativo] La cuenta "
                + cuenta.getNroCuenta()
                + " quedó con saldo negativo"
            );
        }
    }
    

}
