package com.bookshop.bookshop.repository;

import com.bookshop.bookshop.model.CartItem;
import com.bookshop.bookshop.model.User;
import com.bookshop.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomer(User customer);
    void deleteByCustomerAndBook(User customer, Book book);
}
