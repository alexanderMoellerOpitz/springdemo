package com.bewerbung.springdemo.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateDemoEntityRequest {
    @NotBlank(message = "name must be given")
    private String name;
}
