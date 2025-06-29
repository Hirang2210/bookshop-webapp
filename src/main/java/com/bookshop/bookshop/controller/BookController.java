package com.bookshop.bookshop.controller;

import com.bookshop.bookshop.model.Book;
import com.bookshop.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    // ✅ Constructor-based injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @GetMapping("/books")
    public String listBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> books = (keyword == null || keyword.isEmpty())
                ? bookService.findAll()
                : bookService.searchByTitleOrAuthor(keyword);

        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword); // So you can retain the search text in the input box
        return "books";
    }

}

