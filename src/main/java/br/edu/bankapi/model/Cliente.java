package br.edu.bankapi.model;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Cliente {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String nome;
 @Column(nullable=false) private String email;
 @OneToMany(mappedBy="cliente") private List<ContaCorrente> contas = new ArrayList<>();
 public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String v){nome=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
}
