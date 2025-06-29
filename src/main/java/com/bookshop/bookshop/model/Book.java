package com.bookshop.bookshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ✅ Primary Key

    private String title;
    private String author;
    private int year;
    private double price;
    private int copies;
}

