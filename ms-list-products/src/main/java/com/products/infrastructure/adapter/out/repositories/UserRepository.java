package com.products.infrastructure.adapter.out.repositories;


import com.products.infrastructure.adapter.out.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findUserByUsername(String u);

}
