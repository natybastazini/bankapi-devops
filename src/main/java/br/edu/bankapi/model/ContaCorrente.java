package br.edu.bankapi.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
public class ContaCorrente {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String agencia;
 @Column(nullable=false) private String numero;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal saldo=BigDecimal.ZERO;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="cliente_id",nullable=false) private Cliente cliente;
 public Long getId(){return id;} public String getAgencia(){return agencia;} public void setAgencia(String v){agencia=v;} public String getNumero(){return numero;} public void setNumero(String v){numero=v;} public BigDecimal getSaldo(){return saldo;} public void setSaldo(BigDecimal v){saldo=v;} public Cliente getCliente(){return cliente;} public void setCliente(Cliente v){cliente=v;}
}
