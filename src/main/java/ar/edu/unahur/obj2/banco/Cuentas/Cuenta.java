package ar.edu.unahur.obj2.banco.Cuentas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.banco.observadores.*;
import ar.edu.unahur.obj2.banco.operaciones.Deposito;
import ar.edu.unahur.obj2.banco.operaciones.IOperacion;
import ar.edu.unahur.obj2.banco.operaciones.Retiro;

public class Cuenta {
    private final Integer nroCuenta;
    private Double saldo = 0.0;
    private List<IObservadorCuenta> observadores = new ArrayList<>();

    public Cuenta(Integer nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Cuenta(Integer nroCuenta, Double saldo) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public Integer getNroCuenta() {
        return nroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double monto){
        this.saldo += monto;
        notificar(new Deposito(), monto);
    }

    public void retirar(Double monto){
        this.saldo -= monto;
        notificar (new Retiro(), monto);
    }

    public void agregarObservador(IObservadorCuenta unObservador){
        observadores.add(unObservador);
    }

    public void eliminarObservador(IObservadorCuenta unObservador){
        observadores.remove(unObservador);
    }

    public void notificar(IOperacion operacion, Double monto){
        observadores.forEach(o->o.notificar(this, operacion, monto));
    }
}
