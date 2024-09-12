package br.com.MSCategoria.controller;

import br.com.MSCategoria.dtos.CategoriaRequest;
import br.com.MSCategoria.dtos.CategoriaResponse;
import br.com.MSCategoria.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CategoriaResponse>> buscarCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoriaResponse> buscarCategoriaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping("/post")
    public ResponseEntity<CategoriaResponse> novaCategoria(@RequestBody @Valid CategoriaRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }
}
