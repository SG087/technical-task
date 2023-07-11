package ru.sg.technicalTask.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetailsRequest {
    @NotBlank(message = "The email field should not be empty.")
    @Email(message = "Invalid email format.")
    @Length(max = 255, message = "Email length must be smaller than 255 symbols.")
    private String email;
    @Pattern(regexp = "\\+7\\d{10}", message = "Invalid phone number format. Expected format: +7xxxxxxxxxx")
    private String phoneNumber;
}
