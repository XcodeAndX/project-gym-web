package modelo.services;

import modelo.tests_deportivos.testCooper;

import java.util.List;

public interface testCooperServices {
    public List<testCooper> consultar();
    public int crear(testCooper cooperDTO);
    public int actualizar(testCooper cooperDTO);
    public int eliminar(testCooper cooperDTO);
}
