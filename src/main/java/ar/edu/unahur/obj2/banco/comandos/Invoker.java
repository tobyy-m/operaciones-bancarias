package ar.edu.unahur.obj2.banco.comandos;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    //private IOperacion operacion; //operacion == comando --> esto es para ejecutar un solo comando
    private List<IComando> operaciones = new ArrayList<>();
    private List<IComando> ultimasOperaciones = new ArrayList<>();

    public Invoker(List<IComando> operaciones) {
        this.operaciones = operaciones;
    }

    public void agregarOperacion(IComando operacion){
        operaciones.add(operacion);
    }

    public Invoker() {
    }

    public void ejecutarLote(){
        operaciones.forEach(IComando::ejecutar);
        operaciones.forEach(o->ultimasOperaciones.add(o));
        operaciones.clear();
    }

    public void revertirUltimaEjecucion(){
        ultimasOperaciones.forEach(IComando::deshacer);
    }
    


}
