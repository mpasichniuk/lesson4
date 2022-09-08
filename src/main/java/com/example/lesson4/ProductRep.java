package com.example.lesson4;

import java.awt.print.Pageable;

public class ProductRep {'@Repository
    public interface UserRepository extends JpaRepository<ProductDTO, Long>, QuerydslPredicateExecutor<ProductDTO> {

        Page<ProductDTO> findAllByUsernameLike(String productDTOFilter, Pageable pageable);

        @Query(value = """
            select * from products u
            where (:productTitleFilter is null or u.productTitlelike :productTitleFilter)
            and (:costFilter is null or u.email like :costFilter)
            """,
                countQuery = """
            select count(*) from products u
            where (:productDTOFilter is null or u.username like :productDTOFilter)
            and (:productDTOFilter is null or u.email like :productDTOFilter)
            """,
                nativeQuery = true)
        Page<ProductDTO> usersByFilter(String productTitleFilter, String productDTOFilter, Pageable pageable);



    }'
}
