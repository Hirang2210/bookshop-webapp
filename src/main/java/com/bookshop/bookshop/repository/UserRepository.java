package com.bookshop.bookshop.repository;

import com.bookshop.bookshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookshop.bookshop.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
