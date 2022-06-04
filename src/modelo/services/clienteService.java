package modelo.services;

import modelo.dto.cliente;

import java.util.List;

public interface clienteService {

        public List<cliente> consultar();
        public int crear(cliente personaDTO);
        public int actualizar(cliente personaDTO);
        public int eliminar(cliente personaDTO);

}
