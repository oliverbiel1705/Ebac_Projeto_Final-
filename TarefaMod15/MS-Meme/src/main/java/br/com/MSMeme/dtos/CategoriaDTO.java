package br.com.MSMeme.dtos;

import java.sql.Date;

public record CategoriaDTO(
        String nome,
        String descricao,
        Date dataCadastro,
        Long usuarioId
) {
}
