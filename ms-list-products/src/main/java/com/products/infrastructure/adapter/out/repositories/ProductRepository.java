package com.products.infrastructure.adapter.out.repositories;

import com.products.infrastructure.adapter.out.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}