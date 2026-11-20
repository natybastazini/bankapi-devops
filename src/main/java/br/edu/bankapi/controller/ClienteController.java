package br.edu.bankapi.controller;
import br.edu.bankapi.dto.*;
import br.edu.bankapi.model.Cliente;
import br.edu.bankapi.repository.ClienteRepository;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/clientes")
public class ClienteController {
 private final ClienteRepository repository;
 public ClienteController(ClienteRepository repository){this.repository=repository;}
 private ClienteResponse converter(Cliente c){return new ClienteResponse(c.getId(),c.getNome(),c.getEmail());}
 @GetMapping public List<ClienteResponse> listar(){return repository.findAll().stream().map(this::converter).toList();}
 @GetMapping("/{id}") public ResponseEntity<ClienteResponse> buscar(@PathVariable Long id){return repository.findById(id).map(this::converter).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @PostMapping public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest request){Cliente c=new Cliente();c.setNome(request.nome());c.setEmail(request.email());Cliente salvo=repository.save(c);return ResponseEntity.created(URI.create("/api/clientes/"+salvo.getId())).body(converter(salvo));}
}
