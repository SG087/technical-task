package ru.sg.technicalTask.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sg.technicalTask.dto.UserRequest;
import ru.sg.technicalTask.dto.UserResponse;
import ru.sg.technicalTask.model.User;


@Component
@RequiredArgsConstructor
public class MapperImpl implements Mapper {

    private final ModelMapper modelMapper;

    @Override
    public UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public User toEntity(UserResponse userResponse) {
        return modelMapper.map(userResponse, User.class);
    }

    @Override
    public User toEntity(UserRequest request) {
        return modelMapper.map(request, User.class);
    }

}
