package com.hex.app.infrastructure.adapters.output.persistence.mapper;

import com.hex.app.domain.model.Student;
import com.hex.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

// Mismos campos podemos obviar el mapeo lo hara automaticamente
@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {
    StudentEntity toStudentEntity(Student student);
    Student toStudent(StudentEntity studentEntity);
    List<Student> toStudentList(List<StudentEntity> entityList);
}   