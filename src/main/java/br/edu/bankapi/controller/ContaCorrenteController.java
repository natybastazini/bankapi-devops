package br.edu.bankapi.controller;
import br.edu.bankapi.dto.*;
import br.edu.bankapi.model.*;
import br.edu.bankapi.repository.*;
import jakarta.validation.Valid;
import java.net.URI;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/contas")
public class ContaCorrenteController {
 private final ContaCorrenteRepository contas; private final ClienteRepository clientes;
 public ContaCorrenteController(ContaCorrenteRepository contas,ClienteRepository clientes){this.contas=contas;this.clientes=clientes;}
 private ContaResponse converter(ContaCorrente c){return new ContaResponse(c.getId(),c.getAgencia(),c.getNumero(),c.getSaldo(),c.getCliente().getId());}
 @GetMapping public List<ContaResponse> listar(){return contas.findAll().stream().map(this::converter).toList();}
 @GetMapping("/{id}") public ResponseEntity<ContaResponse> buscar(@PathVariable Long id){return contas.findById(id).map(this::converter).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @PostMapping public ResponseEntity<ContaResponse> criar(@Valid @RequestBody ContaRequest request){return clientes.findById(request.clienteId()).map(cliente->{ContaCorrente c=new ContaCorrente();c.setAgencia(request.agencia());c.setNumero(request.numero());c.setSaldo(BigDecimal.ZERO);c.setCliente(cliente);ContaCorrente salvo=contas.save(c);return ResponseEntity.created(URI.create("/api/contas/"+salvo.getId())).body(converter(salvo));}).orElseGet(()->ResponseEntity.notFound().build());}
}
