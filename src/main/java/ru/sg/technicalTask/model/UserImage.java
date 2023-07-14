package ru.sg.technicalTask.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserImage {
    private MultipartFile file;
}
