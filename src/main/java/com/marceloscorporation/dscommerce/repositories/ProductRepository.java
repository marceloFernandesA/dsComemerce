package com.marceloscorporation.dscommerce.repositories;

import com.marceloscorporation.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
