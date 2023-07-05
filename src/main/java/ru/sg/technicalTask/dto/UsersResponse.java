package ru.sg.technicalTask.dto;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UsersResponse {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private DetailsResponse details;
}
