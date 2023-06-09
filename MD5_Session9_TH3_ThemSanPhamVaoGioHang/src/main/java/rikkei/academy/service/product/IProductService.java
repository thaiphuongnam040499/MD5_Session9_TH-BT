package rikkei.academy.service.product;

import rikkei.academy.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);

}
