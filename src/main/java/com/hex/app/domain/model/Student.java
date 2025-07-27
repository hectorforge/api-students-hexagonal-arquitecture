package com.hex.app.domain.model;

import lombok.*;

// Modelo de dominio un simple POJO
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Student {
    private Long id;
    private String firstname;
    private String lastName;
    private Integer age;
    private String address;
}