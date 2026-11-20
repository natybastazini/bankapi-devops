package br.edu.bankapi.repository;
import br.edu.bankapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente,Long> {}
