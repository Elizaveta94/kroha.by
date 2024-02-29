package com.kroha.service.mapper;

import com.kroha.domain.ProductDto;
import com.kroha.persist.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mapping(target = "photo", ignore = true)
    @Mapping(target = "photoSrc", source = "photo")
    ProductDto mapToDto(ProductEntity source);

    @Mapping(target = "photo", expression="java(productDto.getPhoto().getBytes().length == 0 ? null : productDto.getPhoto().getBytes())")
    ProductEntity mapToEntity(ProductDto productDto) throws IOException;

    List<ProductDto> mapToDto(List<ProductEntity> source);
}
