package br.edu.bankapi.dto;
import jakarta.validation.constraints.*;
public record ContaRequest(@NotNull Long clienteId,@NotBlank String agencia,@NotBlank String numero) {}
