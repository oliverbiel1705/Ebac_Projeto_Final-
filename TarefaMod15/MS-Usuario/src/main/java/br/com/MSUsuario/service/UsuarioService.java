package br.com.MSUsuario.service;

import br.com.MSUsuario.dtos.UsuarioRequest;
import br.com.MSUsuario.dtos.UsuarioResponse;
import br.com.MSUsuario.exception.UsuarioNaoEncontradoException;
import br.com.MSUsuario.repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final IUsuarioRepository repository;

    public UsuarioService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioResponse> findAll() {
        return repository.findAll().stream()
                .map(UsuarioResponse::fromResponse)
                .toList();
    }

    public UsuarioResponse findById(Long id) {
        var usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado."));
        return UsuarioResponse.fromResponse(usuario);
    }

    @Transactional
    public UsuarioResponse save(UsuarioRequest u) {
        return UsuarioResponse.fromResponse(
                repository.save(
                        UsuarioRequest.fromEntity(u)
                )
        );
    }
}
