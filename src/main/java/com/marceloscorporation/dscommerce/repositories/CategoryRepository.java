package com.marceloscorporation.dscommerce.repositories;

import com.marceloscorporation.dscommerce.entities.Category;
import com.marceloscorporation.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {




}
