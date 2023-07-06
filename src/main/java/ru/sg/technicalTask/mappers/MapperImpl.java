package ru.sg.technicalTask.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sg.technicalTask.dto.DetailsRequest;
import ru.sg.technicalTask.dto.DetailsResponse;
import ru.sg.technicalTask.dto.UserRequest;
import ru.sg.technicalTask.dto.UserResponse;
import ru.sg.technicalTask.model.Details;
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
    public User toEntity(UserRequest request) {
        return modelMapper.map(request, User.class);
    }

    @Override
    public DetailsResponse toResponse(Details details) {
        return modelMapper.map(details, DetailsResponse.class);
    }

    @Override
    public Details toEntity(DetailsRequest request) {
        return modelMapper.map(request, Details.class);
    }

}
