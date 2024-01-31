package com.kroha.service.impl;

import com.kroha.domain.ProductDto;
import com.kroha.persist.entity.ProductEntity;
import com.kroha.persist.repository.ProductRepository;
import com.kroha.service.ProductService;
import com.kroha.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto create(ProductDto productDto, Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id: " + id));
        productEntity = productMapper.mapToEntity(productDto, productEntity);
        productEntity = productRepository.save(productEntity);
        return productMapper.mapToDto(productEntity);
    }

    @Override
    public void delete(Long id) {
        ProductEntity announcementEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id: " + id));
        productRepository.delete(announcementEntity);
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productMapper.mapToDto(productEntities);
    }
}
