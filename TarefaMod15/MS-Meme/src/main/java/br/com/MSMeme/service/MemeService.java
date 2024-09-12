package br.com.MSMeme.service;

import br.com.MSMeme.dtos.MemeRequest;
import br.com.MSMeme.dtos.MemeResponse;
import br.com.MSMeme.exception.IdCategoriaNaoEncontradaException;
import br.com.MSMeme.exception.IdUsuarioNaoEncontradoException;
import br.com.MSMeme.exception.MemeNaoEncontradoException;
import br.com.MSMeme.feign.CategoriaFeign;
import br.com.MSMeme.feign.UsuarioFeign;
import br.com.MSMeme.repository.IMemeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MemeService {
    private final IMemeRepository repository;
    private final CategoriaFeign categoriaFeign;
    private final UsuarioFeign usuarioFeign;

    public MemeService(IMemeRepository repository, CategoriaFeign categoriaFeign, UsuarioFeign usuarioFeign) {
        this.repository = repository;
        this.categoriaFeign = categoriaFeign;
        this.usuarioFeign = usuarioFeign;
    }

    private boolean buscarUsuarioFeign(MemeRequest m) {
        var usuario = usuarioFeign.getUsuarioById(m.idUsuario());
        return usuario.getStatusCode().is2xxSuccessful();
    }

    private boolean buscarCategoriaFeign(MemeRequest m) {
        var categoria = categoriaFeign.getCategoriaById(m.idCategoriaMeme());
        return categoria.getStatusCode().is2xxSuccessful();
    }

    public List<MemeResponse> findAll() {
        return repository.findAll().stream()
                .map(MemeResponse::fromResponse)
                .toList();
    }

    public MemeResponse findById(Long id) {
        var meme = repository.findById(id)
                .orElseThrow(() -> new MemeNaoEncontradoException("Meme nao encontrado."));
        return MemeResponse.fromResponse(meme);
    }

    public MemeResponse memeDoDia() {
        var memes = findAll();
        if (memes.isEmpty()) {
            throw new RuntimeException("Não contem memes cadastrados.");
        }
        return memes.get(new Random().nextInt(memes.size()));
    }

    @Transactional
    public MemeResponse save(MemeRequest m) {
        if (!buscarUsuarioFeign(m)) {
            throw new IdUsuarioNaoEncontradoException("Usuario nao encontrado.");
        }
        if (!buscarCategoriaFeign(m)) {
            throw new IdCategoriaNaoEncontradaException("Categoria nao encontrada.");
        }
        return MemeResponse.fromResponse(
                repository.save(
                        MemeRequest.fromEntity(m)
                )
        );
    }
}
