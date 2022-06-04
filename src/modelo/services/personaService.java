package modelo.services;

import java.util.List;

public interface personaService {
    public List<persona> consultar();
    public int crear(persona personaDTO);
    public int actualizar(persona personaDTO);
    public int eliminar(persona personaDTO);
}
