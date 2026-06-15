package com.driagon.products.services;

import com.driagon.products.models.Command;
import com.driagon.products.models.dto.ProductDto;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements IProductCommandService {

    private final StreamBridge bridge;

    public ProductCommandServiceImpl(StreamBridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public void sendCreate(ProductDto dto) {
        Command<ProductDto> command = new Command<>("CREATE", null, dto);
        boolean sent = bridge.send("commands-out-0", command);

        if (!sent) {
            throw new IllegalStateException("Could not be sent message to kafka");
        }
    }
}