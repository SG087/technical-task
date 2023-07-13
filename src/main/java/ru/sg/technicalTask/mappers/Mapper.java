package ru.sg.technicalTask.mappers;

import ru.sg.technicalTask.dto.*;
import ru.sg.technicalTask.model.Details;
import ru.sg.technicalTask.model.User;
import ru.sg.technicalTask.model.UserImage;

public interface Mapper {
    UserResponse toResponse(User user);
    User toEntity(UserRequest request);
    DetailsResponse toResponse(Details details);
    Details toEntity(DetailsRequest request);
    UserImage toEntity(UserImageDto dto);
}
