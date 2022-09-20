package com.example.lesson4;

import com.example.lesson4.Product;
import com.example.lesson4.ProductDTO;
import com.example.lesson4.ProductRep;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {



        private final Product.ProductDtoMapper mapper;
        private final ProductRep productRep;

        public Page<ProductDTO> findAllByFilter(String productTitleFilter, String costFilter, int page, int size, String sortField) {
            productTitleFilter = productTitleFilter == null || productTitleFilter.isBlank() ? null : "%" + productTitleFilter.trim() + "%";
            costFilter = costFilter == null || costFilter.isBlank() ? null : "%" + costFilter.trim() + "%";
            return productRep.productsByFilter(productTitleFilter, costFilter, PageRequest.of(page, size, Sort.by(sortField)))
                    .map(mapper::map);
        }

        public Optional<ProductDTO> findProductById(Long id) {
            return productRep.findById(id).map(mapper::map);
        }

        public void save(ProductDTO dto) {
            productRep.save(mapper.map(dto));
        }

        public void deleteProductById(Long id) {
            productRep.deleteById(id);
        }

    }
