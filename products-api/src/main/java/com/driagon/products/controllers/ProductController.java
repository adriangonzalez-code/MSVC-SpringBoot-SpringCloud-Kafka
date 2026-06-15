package com.driagon.products.controllers;

import com.driagon.products.models.dto.ProductDto;
import com.driagon.products.services.IProductCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductCommandService commandService;

    public ProductController(IProductCommandService commandService) {
        this.commandService = commandService;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductDto dto) {
        this.commandService.sendCreate(dto);
        return ResponseEntity.ok(Map.of("message", "Product created successfully"));
    }
}