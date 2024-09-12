package br.com.MSMeme.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "tb_meme")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "id_categoria", nullable = false)
    private Long idCategoriaMeme;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;
}
