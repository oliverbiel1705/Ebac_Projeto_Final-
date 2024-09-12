package br.com.MSUsuario.dtos;

import br.com.MSUsuario.model.Usuario;
import lombok.Builder;

import java.sql.Date;

@Builder
public record UsuarioResponse(
        String nome,
        String email,
        Date dataCadastro
) {
    public static UsuarioResponse fromResponse(Usuario u) {
        return UsuarioResponse.builder()
                .nome(u.getNome())
                .email(u.getEmail())
                .dataCadastro(u.getDataCadastro())
                .build();
    }
}
