package br.com.MSCategoria.service;

import br.com.MSCategoria.dtos.CategoriaRequest;
import br.com.MSCategoria.dtos.CategoriaResponse;
import br.com.MSCategoria.exceptions.CategoriaNaoEncontradaException;
import br.com.MSCategoria.exceptions.IdUsuarioNaoEncontradoException;
import br.com.MSCategoria.feign.UsuarioFeign;
import br.com.MSCategoria.repository.ICategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final ICategoriaRepository repository;
    private final UsuarioFeign usuarioFeign;

    public CategoriaService(ICategoriaRepository repository, UsuarioFeign usuarioFeign) {
        this.repository = repository;
        this.usuarioFeign = usuarioFeign;
    }

    private boolean buscarUsuarioFeign(CategoriaRequest c) {
        var usuario = usuarioFeign.getUsuarioById(c.usuarioId());
        return usuario.getStatusCode().is2xxSuccessful();
    }

    public List<CategoriaResponse> findAll() {
        return repository.findAll().stream()
                .map(CategoriaResponse::fromResponse)
                .toList();
    }

    public CategoriaResponse findById(Long id) {
        var categoria = repository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException("Categoria nao encontrada."));
        return CategoriaResponse.fromResponse(categoria);
    }

    @Transactional
    public CategoriaResponse save(CategoriaRequest c) {
        if (!buscarUsuarioFeign(c)) {
            throw new IdUsuarioNaoEncontradoException("Usuario nao encontrado.");
        }
        return CategoriaResponse.fromResponse(
                repository.save(
                        CategoriaRequest.fromEntity(c)
                )
        );
    }
}
