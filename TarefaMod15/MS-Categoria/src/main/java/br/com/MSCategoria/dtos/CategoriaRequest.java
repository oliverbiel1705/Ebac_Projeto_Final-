package br.com.MSCategoria.dtos;

import br.com.MSCategoria.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.sql.Date;
import java.time.LocalDate;

@Builder
public record CategoriaRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Long usuarioId

) {
    public static Categoria fromEntity(CategoriaRequest c) {
        return Categoria.builder()
                .nome(c.nome)
                .descricao(c.descricao)
                .dataCadastro(Date.valueOf(LocalDate.now()))
                .usuarioId(c.usuarioId)
                .build();
    }
}
