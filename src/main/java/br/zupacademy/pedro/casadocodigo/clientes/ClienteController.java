package br.zupacademy.pedro.casadocodigo.clientes;

import br.zupacademy.pedro.casadocodigo.estado.Estadorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    private Estadorepository estadorepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository, Estadorepository estadorepository) {
        this.clienteRepository = clienteRepository;
        this.estadorepository = estadorepository;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> insertCliente(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = clienteRequestDTO.convertToCliente();
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteResponseDTO(cliente));
    }

}
