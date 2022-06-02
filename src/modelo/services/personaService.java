package modelo.services;

import modelo.dto.cliente;
import modelo.dto.persona;

import java.util.List;

public interface personaService {
    public List<persona> consultar();
    public int crear(persona personaDTO);
    public int actualizar(persona personaDTO);
    public int eliminar(persona personaDTO);
}
