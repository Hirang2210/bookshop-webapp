package com.bookshop.bookshop.controller;

import com.bookshop.bookshop.model.Book;
import com.bookshop.bookshop.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final BookRepository bookRepository;

    public AdminController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "admin/dashboard"; // Thymeleaf template
    }

    @GetMapping("/add-book")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "admin/add-book";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/edit-book/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).orElseThrow());
        return "admin/edit-book";
    }

    @PostMapping("/edit-book")
    public String editBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }
}

