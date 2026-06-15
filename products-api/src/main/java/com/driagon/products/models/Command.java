package com.driagon.products.models;

public record Command<T>(String type, Long id, T body) {
}