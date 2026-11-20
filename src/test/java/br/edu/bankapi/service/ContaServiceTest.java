package br.edu.bankapi.service;
import br.edu.bankapi.model.ContaCorrente;
import br.edu.bankapi.repository.ContaCorrenteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ContaServiceTest {
 @Mock ContaCorrenteRepository repository;
 @InjectMocks ContaService service;
 @Test void deveSacar() {
  ContaCorrente conta=new ContaCorrente(); conta.setSaldo(new BigDecimal("1000.00"));
  when(repository.findById(1L)).thenReturn(Optional.of(conta));
  when(repository.save(any(ContaCorrente.class))).thenAnswer(invocation -> invocation.getArgument(0));
  ContaCorrente resultado=service.sacar(1L,new BigDecimal("300.00"));
  assertEquals(0,new BigDecimal("700.00").compareTo(resultado.getSaldo()));
  verify(repository).save(conta);
 }
 @Test void naoDevePermitirSaldoInsuficiente() {
  ContaCorrente conta=new ContaCorrente(); conta.setSaldo(new BigDecimal("100.00"));
  when(repository.findById(1L)).thenReturn(Optional.of(conta));
  assertThrows(IllegalArgumentException.class, () -> service.sacar(1L,new BigDecimal("200.00")));
  verify(repository,never()).save(any());
 }

 @Test void deveDepositarValorPositivo() {
  ContaCorrente conta=new ContaCorrente(); conta.setSaldo(new BigDecimal("100.00"));
  when(repository.findById(1L)).thenReturn(Optional.of(conta));
  when(repository.save(any(ContaCorrente.class))).thenAnswer(invocation -> invocation.getArgument(0));
  ContaCorrente resultado=service.depositar(1L,new BigDecimal("50.00"));
  assertEquals(0,new BigDecimal("150.00").compareTo(resultado.getSaldo()));
  verify(repository).save(conta);
 }
 @Test void naoDeveDepositarValorZero() {
  assertThrows(IllegalArgumentException.class, () -> service.depositar(1L,BigDecimal.ZERO));
  verify(repository,never()).save(any());
 }
 @Test void naoDeveDepositarValorNegativo() {
  assertThrows(IllegalArgumentException.class, () -> service.depositar(1L,new BigDecimal("-10.00")));
  verify(repository,never()).save(any());
 }
 @Test void deveSacarValorExatoDoSaldo() {
  ContaCorrente conta=new ContaCorrente(); conta.setSaldo(new BigDecimal("100.00"));
  when(repository.findById(1L)).thenReturn(Optional.of(conta));
  when(repository.save(any(ContaCorrente.class))).thenAnswer(invocation -> invocation.getArgument(0));
  ContaCorrente resultado=service.sacar(1L,new BigDecimal("100.00"));
  assertEquals(0,BigDecimal.ZERO.compareTo(resultado.getSaldo()));
  verify(repository).save(conta);
 }
 @Test void naoDeveOperarContaInexistente() {
  when(repository.findById(99L)).thenReturn(Optional.empty());
  assertThrows(IllegalArgumentException.class, () -> service.depositar(99L,new BigDecimal("10.00")));
  assertThrows(IllegalArgumentException.class, () -> service.sacar(99L,new BigDecimal("10.00")));
  verify(repository,never()).save(any());
 }

}
