package com.kroha.service.mapper;

import com.kroha.domain.ProductDto;
import com.kroha.persist.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto mapToDto(ProductEntity source);

    ProductEntity mapToEntity(ProductDto productDto, ProductEntity productEntity);

    List<ProductDto> mapToDto(List<ProductEntity> source);
}
