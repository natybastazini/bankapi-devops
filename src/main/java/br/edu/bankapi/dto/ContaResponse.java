package br.edu.bankapi.dto;
import java.math.BigDecimal;
public record ContaResponse(Long id,String agencia,String numero,BigDecimal saldo,Long clienteId) {}
