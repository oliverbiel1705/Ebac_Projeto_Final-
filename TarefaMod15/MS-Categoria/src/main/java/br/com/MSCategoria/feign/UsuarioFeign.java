package br.com.MSCategoria.feign;

import br.com.MSCategoria.dtos.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-Usuario")
public interface UsuarioFeign {
    @GetMapping("/usuario/get/{id}")
    ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id);
}
