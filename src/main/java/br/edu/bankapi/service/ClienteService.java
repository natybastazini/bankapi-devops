package br.edu.bankapi.service;
import br.edu.bankapi.model.Cliente;
import br.edu.bankapi.repository.ClienteRepository;
import org.springframework.stereotype.Service;
@Service
public class ClienteService {
 private final ClienteRepository repository;
 public ClienteService(ClienteRepository repository) { this.repository=repository; }
 public Cliente buscarPorId(Long id) { return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado")); }
 public Cliente cadastrar(Cliente cliente) {
  if(cliente.getNome()==null || cliente.getNome().isBlank()) throw new IllegalArgumentException("Nome obrigatório");
  return repository.save(cliente);
 }
}
