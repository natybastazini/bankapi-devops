package br.edu.bankapi.service;
import br.edu.bankapi.model.Cliente;
import br.edu.bankapi.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
 @Mock ClienteRepository repository;
 @InjectMocks ClienteService service;
 @Test void deveBuscarClientePorId() {
  Cliente cliente=new Cliente(); cliente.setNome("Maria");
  when(repository.findById(1L)).thenReturn(Optional.of(cliente));
  assertEquals("Maria",service.buscarPorId(1L).getNome());
  verify(repository).findById(1L);
 }
}
