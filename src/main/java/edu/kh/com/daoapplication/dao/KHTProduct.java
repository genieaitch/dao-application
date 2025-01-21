package edu.kh.com.daoapplication.dao;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KHTProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int stock;
}
