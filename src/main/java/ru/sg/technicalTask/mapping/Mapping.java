package ru.sg.technicalTask.mapping;

import ru.sg.technicalTask.dto.UsersResponse;
import ru.sg.technicalTask.model.Users;

public interface Mapping {
    UsersResponse toResponse(Users users);
    Users toEntity(UsersResponse userResponse);
}
