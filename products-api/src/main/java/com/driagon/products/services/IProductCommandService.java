package com.driagon.products.services;

import com.driagon.products.models.dto.ProductDto;

public interface IProductCommandService {

    void sendCreate(ProductDto dto);
}