package modelo.services;

import modelo.dto.cliente;
import modelo.dto.persona;

import java.util.List;

public interface clienteService {

        public List<persona> consultar();
        public int crear(persona personaDTO);
        public int actualizar(cliente personaDTO);
        public int eliminar(cliente personaDTO);

}
