package com.example.lesson4;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

public class Product {

    @Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public interface ProductDtoMapper {

        @Mapping(target = "cost", ignore = true)
        ProductDTO map(ProductDTO product);

        @Mapping(target = "id", ignore = true)
        ProductDTO map(Product product);

    }
}
