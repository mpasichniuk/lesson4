package com.example.lesson4;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

public class ProductRep {
    public ProductDTOMapping productsByFilter(String productTitleFilter, String costFilter, PageRequest of) {
    }

    public void save(ProductDTO map) {
    }

    @Repository
    public interface ProductRepository extends JpaRepository<ProductDTO, Long>, QuerydslPredicateExecutor<ProductDTO> {

        Page<ProductDTO> findAllByProductTitleLike(String productDTOFilter, Pageable pageable);

        @Query(value = """
            select * from products u
            where (:productTitleFilter is null or u.productTitlelike :productTitleFilter)
            and (:costFilter is null or u.productTitle like :costFilter)
            """,
                countQuery = """
            select count(*) from products u
            where (:productDTOFilter is null or u.productTitle like :productDTOFilter)
            and (:productDTOFilter is null or u.productTitle like :productDTOFilter)
            """,
                nativeQuery = true)
        Page<ProductDTO> productsByFilter(String productTitleFilter, String productDTOFilter, Pageable pageable);



    }
}
