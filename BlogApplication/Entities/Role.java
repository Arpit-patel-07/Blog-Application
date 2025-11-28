package com.example.BlogApplication.Entities;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Role {

    @Id
    private int id;
    private String name;
}

