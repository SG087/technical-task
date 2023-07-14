package ru.sg.technicalTask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private DetailsResponse details;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> images;
}
