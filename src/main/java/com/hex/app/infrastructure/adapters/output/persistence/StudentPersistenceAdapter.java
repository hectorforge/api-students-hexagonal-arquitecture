package com.hex.app.infrastructure.adapters.output.persistence;

import com.hex.app.application.ports.output.StudentPersistencePort;
import com.hex.app.domain.exception.StudentNotFoundException;
import com.hex.app.domain.model.Student;
import com.hex.app.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.hex.app.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentRepository studentRepository;
    private final StudentPersistenceMapper studentPersistenceMapper;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id)
                .map(studentPersistenceMapper::toStudent);
    }

    @Override
    public List<Student> findAll() {
        return studentPersistenceMapper.toStudentList(studentRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return studentPersistenceMapper.toStudent(studentRepository
                .save(studentPersistenceMapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
