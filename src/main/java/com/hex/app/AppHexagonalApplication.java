package com.hex.app;

import com.hex.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import com.hex.app.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AppHexagonalApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;

    // Ejecuto esto para anotar datos de entrada
    @Override
    public void run(String... args) throws Exception {
        List<StudentEntity> entities = Arrays.asList(
                new StudentEntity(null, "Héctor", "Ramírez", 22, "Av. Los Próceres 123"),
                new StudentEntity(null, "María", "González", 24, "Calle Falsa 123"),
                new StudentEntity(null, "Luis", "Fernández", 21, "Jr. Las Flores 456"),
                new StudentEntity(null, "Ana", "Torres", 23, "Av. Perú 789"),
                new StudentEntity(null, "Carlos", "Quispe", 25, "Calle Bolívar 321"),
                new StudentEntity(null, "Lucía", "Reyes", 22, "Jr. Amazonas 654")
        );
        studentRepository.saveAll(entities);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppHexagonalApplication.class, args);
    }

}