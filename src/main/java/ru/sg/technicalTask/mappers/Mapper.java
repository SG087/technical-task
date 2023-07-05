package ru.sg.technicalTask.mappers;

import ru.sg.technicalTask.dto.UsersResponse;
import ru.sg.technicalTask.model.Users;

public interface Mapper {
    UsersResponse toResponse(Users users);
    Users toEntity(UsersResponse userResponse);
}
