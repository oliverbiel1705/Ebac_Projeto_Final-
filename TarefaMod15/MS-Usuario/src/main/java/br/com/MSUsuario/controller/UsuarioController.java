package br.com.MSUsuario.controller;

import br.com.MSUsuario.dtos.UsuarioRequest;
import br.com.MSUsuario.dtos.UsuarioResponse;
import br.com.MSUsuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<List<UsuarioResponse>> buscaUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UsuarioResponse> buscaUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping("/post")
    public ResponseEntity<UsuarioResponse> novoUsuario(@RequestBody @Valid UsuarioRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }
}
