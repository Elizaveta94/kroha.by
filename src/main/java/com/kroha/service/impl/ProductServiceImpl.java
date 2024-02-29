package com.kroha.service.impl;

import com.kroha.domain.ProductDto;
import com.kroha.persist.entity.ProductEntity;
import com.kroha.persist.repository.ProductRepository;
import com.kroha.service.ProductService;
import com.kroha.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private ProductEntity productEntity;

    public static final int PAGE_SIZE = 16;
    @Override
    @SneakyThrows
    @Transactional
    public ProductDto create(ProductDto productDto) {
        productEntity = productMapper.mapToEntity(productDto);
        productEntity = productRepository.save(productEntity);
        return productMapper.mapToDto(productEntity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        ProductEntity announcementEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id: " + id));
        productRepository.delete(announcementEntity);
    }

    @Transactional
    @Override
    public List<ProductDto> getAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productMapper.mapToDto(productEntities);
    }

    @Override
    public byte[] getPhoto(Long id) {
        return productRepository.findById(id).get().getPhoto();
    }

    @Override
    public ProductDto getById(Long id) {
        return productMapper.mapToDto(productRepository.findById(id).get());
    }
}
