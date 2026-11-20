package br.edu.bankapi.service;
import br.edu.bankapi.model.ContaCorrente;
import br.edu.bankapi.repository.ContaCorrenteRepository;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
@Service
public class ContaService {
 private final ContaCorrenteRepository repository;
 public ContaService(ContaCorrenteRepository repository) {this.repository=repository;}
 public ContaCorrente depositar(Long contaId, BigDecimal valor) {
  validarValor(valor);
  ContaCorrente conta=buscarConta(contaId);
  conta.setSaldo(conta.getSaldo().add(valor));
  return repository.save(conta);
 }
 public ContaCorrente sacar(Long contaId, BigDecimal valor) {
  validarValor(valor);
  ContaCorrente conta=buscarConta(contaId);
  if(conta.getSaldo().compareTo(valor)<0) throw new IllegalArgumentException("Saldo insuficiente");
  conta.setSaldo(conta.getSaldo().subtract(valor));
  return repository.save(conta);
 }
 private ContaCorrente buscarConta(Long id) {return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));}
 private void validarValor(BigDecimal valor) {if(valor==null || valor.compareTo(BigDecimal.ZERO)<=0) throw new IllegalArgumentException("Valor deve ser positivo");}
}
