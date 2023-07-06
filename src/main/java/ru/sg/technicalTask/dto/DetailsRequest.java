package ru.sg.technicalTask.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetailsRequest {
    private String email;
    private String phoneNumber;
}
