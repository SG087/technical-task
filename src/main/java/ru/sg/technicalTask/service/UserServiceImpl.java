package ru.sg.technicalTask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sg.technicalTask.dto.UsersResponse;
import ru.sg.technicalTask.exception.ResourceNotFoundException;
import ru.sg.technicalTask.mappers.Mapper;
import ru.sg.technicalTask.model.Users;
import ru.sg.technicalTask.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper map;

    @Override
    @Transactional(readOnly = true)
    public List<UsersResponse> findAll() {
        return userRepository.findAll().stream()
                .map(map::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsersResponse findById(Long id) {
        Users users = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User is not fount."));

        return map.toResponse(users);
    }

    @Override
    @Transactional
    public void create(UsersResponse response) {
        userRepository.save(map.toEntity(response));
    }

    @Override
    @Transactional
    public void update(UsersResponse response, Long id) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found."));

        Users updateUser = map.toEntity(response);
        updateUser.setId(existingUser.getId());

        userRepository.save(updateUser);
    }

    @Override
    public void delete(Long id) {

    }
}
