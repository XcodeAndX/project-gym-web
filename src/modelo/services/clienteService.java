package modelo.services;

import modelo.dto.cliente;

import java.util.List;

public interface clienteService {

        public List<cliente> consultar();
        public int crear(cliente clienteDTO);
        public int actualizar(cliente clienteDTO);
        public int eliminar(cliente clienteDTO);

}
