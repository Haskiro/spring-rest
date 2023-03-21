package com.github.haskiro.FirstRestApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonDTO {
    private int id;
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 30, message = "Name length must be between 2 and 30 characters")
    private String name;

    @Min(value = 0,  message = "Age must be positive")
    private int age;

    @Email(message = "Email must match the pattern example@example.com")
    @NotEmpty(message = "Email must not be empty")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
