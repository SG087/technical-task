package ru.sg.technicalTask.dto;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
}
