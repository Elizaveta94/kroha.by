package com.kroha.service;

import com.kroha.domain.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto productDto);

    void delete(Long id);

    List<ProductDto> getAll();

    byte[] getPhoto(Long id);

    ProductDto getById(Long id);

}

