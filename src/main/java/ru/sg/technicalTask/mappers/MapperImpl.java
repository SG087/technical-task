package ru.sg.technicalTask.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sg.technicalTask.dto.UsersResponse;
import ru.sg.technicalTask.model.Users;


@Component
@RequiredArgsConstructor
public class MapperImpl implements Mapper {

    private final ModelMapper modelMapper;

    @Override
    public UsersResponse toResponse(Users users) {
        return modelMapper.map(users, UsersResponse.class);
    }

    @Override
    public Users toEntity(UsersResponse userResponse) {
        return modelMapper.map(userResponse, Users.class);
    }

}
