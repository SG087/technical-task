package ru.sg.technicalTask.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetailsResponse {
    private String email;
    private String phoneNumber;
}
