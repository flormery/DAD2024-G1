package com.example.mspedidoservice.feign;

import com.example.mspedidoservice.dto.ClienteDto;
import com.example.mspedidoservice.dto.ProductoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo-service",path = "/producto")
public interface ProductoFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscarPOrId(@PathVariable(required = true) Integer id);
}
