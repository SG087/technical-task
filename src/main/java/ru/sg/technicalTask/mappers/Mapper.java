package ru.sg.technicalTask.mappers;

import ru.sg.technicalTask.dto.UserRequest;
import ru.sg.technicalTask.dto.UserResponse;
import ru.sg.technicalTask.model.User;

public interface Mapper {
    UserResponse toResponse(User user);
    User toEntity(UserRequest request);
}
