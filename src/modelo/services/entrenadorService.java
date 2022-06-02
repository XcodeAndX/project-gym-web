package modelo.services;

import modelo.dto.cliente;
import modelo.dto.entrenador;

import java.util.List;

public interface entrenadorService {
    public List<entrenador> consultar();
    public int crear(entrenador clienteDTO);
    public int actualizar(entrenador clienteDTO);
    public int eliminar(entrenador clienteDTO);
}
