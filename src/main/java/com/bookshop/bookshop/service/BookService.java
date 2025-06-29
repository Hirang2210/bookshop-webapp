package com.bookshop.bookshop.service;

import com.bookshop.bookshop.model.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Book> searchByTitleOrAuthor(String keyword);
}



