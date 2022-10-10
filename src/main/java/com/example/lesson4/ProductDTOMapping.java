package com.example.lesson4;

import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductDTOMapping {


    @Mapping(target = "password", ignore = true)
    ProductDTO map(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "encode")
   ProductDTO map(Product product, @Context PasswordEncoder encoder);

    @Named("encode")
    default String encode(String password, @Context PasswordEncoder encoder) {
        return encoder.encode(password);
    }

}

