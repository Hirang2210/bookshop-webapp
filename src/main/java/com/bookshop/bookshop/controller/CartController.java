package com.bookshop.bookshop.controller;

import com.bookshop.bookshop.model.*;
import com.bookshop.bookshop.repository.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;  // <-- Import added
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final BookRepository bookRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public CartController(BookRepository bookRepository, CartItemRepository cartItemRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/add/{bookId}")
    public String addToCart(@PathVariable Long bookId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        CartItem cartItem = new CartItem(null, user, book, 1);
        cartItemRepository.save(cartItem);

        return "redirect:/cart/view";
    }

    @GetMapping("/view")
    public String viewCart(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<CartItem> cartItems = cartItemRepository.findByCustomer(user);

        double total = cartItems.stream()
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        return "cart/view";
    }

    @Transactional  // <--- Add transactional here to fix your error
    @GetMapping("/remove/{bookId}")
    public String removeFromCart(@PathVariable Long bookId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        cartItemRepository.deleteByCustomerAndBook(user, book);
        return "redirect:/cart/view";
    }

    @PostMapping("/checkout")
    public String placeOrder(@RequestParam String creditCard, Model model) {
        model.addAttribute("message", "Order placed successfully!");
        return "cart/confirmation";
    }
}


