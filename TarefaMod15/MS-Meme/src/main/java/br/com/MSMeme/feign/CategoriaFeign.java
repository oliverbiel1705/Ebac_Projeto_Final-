package br.com.MSMeme.feign;

import br.com.MSMeme.dtos.CategoriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-Categoria")
public interface CategoriaFeign {
    @GetMapping("/categoria/get/{id}")
    ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id);
}
