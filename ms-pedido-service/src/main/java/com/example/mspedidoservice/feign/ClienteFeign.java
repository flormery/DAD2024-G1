package com.example.mspedidoservice.feign;

import com.example.mspedidoservice.dto.ClienteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service",path = "/cliente")
public interface ClienteFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "clienteListarPorIdCB", fallbackMethod = "fallbackClientePorID")
    public ResponseEntity<ClienteDto> busacarPorId(@PathVariable(required = true) Integer id);
    default ResponseEntity<ClienteDto> fallbackClientePorID(Integer id, Exception e) {
        return ResponseEntity.ok(new ClienteDto());
    }
}