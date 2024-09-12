package br.com.MSMeme.controller;

import br.com.MSMeme.dtos.MemeRequest;
import br.com.MSMeme.dtos.MemeResponse;
import br.com.MSMeme.service.MemeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {
    private final MemeService service;

    public MemeController(MemeService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<List<MemeResponse>> buscarMemes() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MemeResponse> buscarMemePorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping("/get/meme-do-dia")
    public ResponseEntity<MemeResponse> memeDoDia() {
        return ResponseEntity.status(HttpStatus.OK).body(service.memeDoDia());
    }

    @PostMapping("/post")
    public ResponseEntity<MemeResponse> novoMeme(@RequestBody @Valid MemeRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }
}
