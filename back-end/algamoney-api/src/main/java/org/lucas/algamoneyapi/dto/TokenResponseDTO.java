package org.lucas.algamoneyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class TokenResponseDTO {
    private String token;
    private String refreshToken;
}
