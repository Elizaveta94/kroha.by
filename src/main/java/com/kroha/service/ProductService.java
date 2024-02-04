package com.kroha.service;

import com.kroha.domain.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto productDto);

    void delete(Long id);

    List<ProductDto> getAll();

}

