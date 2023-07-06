package ru.sg.technicalTask.mappers;

import ru.sg.technicalTask.dto.DetailsRequest;
import ru.sg.technicalTask.dto.DetailsResponse;
import ru.sg.technicalTask.dto.UserRequest;
import ru.sg.technicalTask.dto.UserResponse;
import ru.sg.technicalTask.model.Details;
import ru.sg.technicalTask.model.User;

public interface Mapper {
    UserResponse toResponse(User user);
    User toEntity(UserRequest request);
    DetailsResponse toResponse(Details details);
    Details toEntity(DetailsRequest request);
}
