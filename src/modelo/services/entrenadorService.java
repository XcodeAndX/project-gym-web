package modelo.services;

import modelo.dto.cliente;
import modelo.dto.entrenador;

import java.util.List;

public interface entrenadorService {
    public List<entrenador> consultar();
    public int crear(entrenador entrenadorDTO);
    public int actualizar(entrenador entrenadorDTO);
    public int eliminar(entrenador entrenadorDTO);
}
