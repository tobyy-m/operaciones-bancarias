package ar.edu.unahur.obj2.banco.operaciones;

public class Deposito implements IOperacion {

    @Override
    public String descripcion() {

        return "DEPOSITO";
    }

    @Override
    public String mensajeCliente(Double monto) {

        return "Se acreditaron $ " + monto;
    }
    

}
