package ru.sg.technicalTask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    @NotBlank(message = "The name field should not be empty.")
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.")
    private String firstName;
    @NotBlank(message = "The surname field should not be empty.")
    @Length(max = 255, message = "Surname length must be smaller than 255 symbols.")
    private String lastName;
    @Length(max = 255, message = "Patronymic length must be smaller than 255 symbols.")
    private String patronymic;
    @NotNull(message = "The date of birth field should not be empty.")
    private LocalDate dateOfBirth;
}
