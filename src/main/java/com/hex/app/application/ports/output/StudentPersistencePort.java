package com.hex.app.application.ports.output;

import com.hex.app.domain.model.Student;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.List;

//En la parte del output se tiene los métodos que serán
// necesarios para poder interactuar con la capa externa por ejemplo una de persistencia
@Component
public interface StudentPersistencePort {
    // Llamadas del mundo exterior, operaciones necesarias para persistir
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);
}