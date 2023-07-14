package ru.sg.technicalTask.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sg.technicalTask.dto.*;
import ru.sg.technicalTask.model.Details;
import ru.sg.technicalTask.model.User;
import ru.sg.technicalTask.model.UserImage;

import java.util.ArrayList;


@Component
@RequiredArgsConstructor
public class MapperImpl implements Mapper {

    private final ModelMapper modelMapper;

    @Override
    public UserResponse toResponse(User user) {
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        userResponse.setImages(new ArrayList<>(user.getImages()));
        return userResponse;
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

    @Override
    public UserImage toEntity(UserImageDto dto) {
        return modelMapper.map(dto, UserImage.class);
    }
}
