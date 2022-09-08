package com.example.lesson4;

public class Product {

    @Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public interface ProductDtoMapper {

        @Mapping(target = "cost", ignore = true)
        ProductDto map(ProductDTO productDTO);

        @Mapping(target = "id", ignore = true)
        ProductDto map(ProductDto productDto);

    }
}
