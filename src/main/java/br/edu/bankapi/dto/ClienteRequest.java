package br.edu.bankapi.dto;
import jakarta.validation.constraints.*;
public record ClienteRequest(@NotBlank String nome,@NotBlank @Email String email) {}
