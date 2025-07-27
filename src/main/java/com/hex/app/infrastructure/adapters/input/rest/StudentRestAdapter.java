package com.hex.app.infrastructure.adapters.input.rest;

import com.hex.app.application.ports.input.StudentServicePort;
import com.hex.app.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.hex.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.hex.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestAdapter {
    private final StudentServicePort studentServicePort;
    private final StudentRestMapper studentRestMapper;

    @GetMapping("/v1/api")
    public List<StudentResponse> findAll(){
        return studentRestMapper.toStudentResponse(studentServicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(studentRestMapper
                        .toStudentResponse(studentServicePort.findById(id)));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentRestMapper
                        .toStudentResponse(studentServicePort
                                .save(studentRestMapper.toStudent(request))));
    }

    @PutMapping("v1/api/{id}")
    public ResponseEntity<StudentResponse> update
            (@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRestMapper
                        .toStudentResponse(studentServicePort
                                .update(id,studentRestMapper.toStudent(request))));
    }

    @DeleteMapping("/v1/api/{id}")
    public void deleteById(@PathVariable Long id){
        studentServicePort.deleteById(id);
    }
}
