package ru.sg.technicalTask.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
