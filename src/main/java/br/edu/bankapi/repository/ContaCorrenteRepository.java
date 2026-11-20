package br.edu.bankapi.repository;
import br.edu.bankapi.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente,Long> { List<ContaCorrente> findByClienteId(Long clienteId); }
