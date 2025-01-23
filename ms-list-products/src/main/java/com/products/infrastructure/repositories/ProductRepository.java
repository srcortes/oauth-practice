package com.products.infrastructure.repositories;



import com.products.domain.aggregate.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Integer> {
}