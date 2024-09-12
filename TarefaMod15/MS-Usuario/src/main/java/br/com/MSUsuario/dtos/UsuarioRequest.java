package br.com.MSUsuario.dtos;

import br.com.MSUsuario.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.sql.Date;
import java.time.LocalDate;

@Builder
public record UsuarioRequest(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email
) {
        public static Usuario fromEntity(UsuarioRequest u) {
                return Usuario.builder()
                        .nome(u.nome)
                        .email(u.email)
                        .dataCadastro(Date.valueOf(LocalDate.now()))
                        .build();
        }
}
