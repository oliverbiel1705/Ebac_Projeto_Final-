package br.com.MSCategoria.dtos;

import br.com.MSCategoria.model.Categoria;
import lombok.Builder;

import java.sql.Date;

@Builder
public record CategoriaResponse(
        String nome,
        String descricao,
        Date dataCadastro,
        Long usuarioId
) {
    public static CategoriaResponse fromResponse(Categoria c) {
        return CategoriaResponse.builder()
                .nome(c.getNome())
                .descricao(c.getDescricao())
                .dataCadastro(c.getDataCadastro())
                .usuarioId(c.getUsuarioId())
                .build();
    }
}
