package br.edu.bankapi.dto;
public record LoginResponse(String accessToken, String tokenType, long expiresIn) {}
