package com.application.form.entity;

import jakarta.persistence.*;

@Entity
@lombok.Data
@Table(name = "form_table")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

}
