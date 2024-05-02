package com.example.mspedidoservice.feign;

import com.example.mspedidoservice.dto.ClienteDto;
import com.example.mspedidoservice.dto.ProductoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service",path = "/producto")
public interface ProductoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "pclienteListarPorIdCB", fallbackMethod = "fallbackProductoPorid")
    public ResponseEntity<ProductoDto> buscarPOrId(@PathVariable(required = true) Integer id);
    default ResponseEntity<ProductoDto> fallbackProducto(Integer id, Exception e) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(9000000);
        return ResponseEntity.ok(productoDto);
    }

}
