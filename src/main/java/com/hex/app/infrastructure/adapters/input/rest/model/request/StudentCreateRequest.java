package com.hex.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StudentCreateRequest {
    @NotBlank(message = "Field firstname cannot empty or null")
    private String firstname;
    @NotBlank(message = "Field lastname cannot empty or null")
    private String lastname;
    @NotNull(message = "Field firstname cannot empty or null")
    private Integer age;
    @NotBlank(message = "Field address cannot empty or null")
    private String address;
}