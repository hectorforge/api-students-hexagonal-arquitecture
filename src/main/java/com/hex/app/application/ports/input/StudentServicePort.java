package com.hex.app.application.ports.input;

import com.hex.app.domain.model.Student;

import java.util.List;

// Use cases del sistema como tal (CRUD)
// La capa de la aplicacion  debe tener dependencias del dominio solamente
public interface StudentServicePort {
    Student findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    Student update(Long id,Student student);
    void deleteById(Long id);
}