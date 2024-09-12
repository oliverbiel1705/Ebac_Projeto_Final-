package br.com.MSMeme.dtos;

import br.com.MSMeme.model.Meme;
import lombok.Builder;

import java.sql.Date;

@Builder
public record MemeResponse(
        String nome,
        String descricao,
        String url,
        Date dataCadastro,
        Long idCategoriaMeme,
        Long idUsuario
) {
    public static MemeResponse fromResponse(Meme m) {
        return MemeResponse.builder()
                .nome(m.getNome())
                .descricao(m.getDescricao())
                .url(m.getUrl())
                .dataCadastro(m.getDataCadastro())
                .idCategoriaMeme(m.getIdCategoriaMeme())
                .idUsuario(m.getIdUsuario())
                .build();
    }
}
