package com.hex.app.infrastructure.adapters.input.rest.mapper;

import com.hex.app.domain.model.Student;
import com.hex.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.hex.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/*
* Coloco el unmmppedTargetPolicy a nivel de interfaz para ignorar el campo id
* el cual no viene en el modelo del request
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface StudentRestMapper {
    Student toStudent(StudentCreateRequest request);
    StudentResponse toStudentResponse(Student student);
    List<StudentResponse> toStudentResponse(List<Student> students);
}
