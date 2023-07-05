package ru.sg.technicalTask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sg.technicalTask.dto.UsersResponse;
import ru.sg.technicalTask.mapping.Mapping;
import ru.sg.technicalTask.model.Users;
import ru.sg.technicalTask.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapping map;

    @Override
    @Transactional(readOnly = true)
    public List<UsersResponse> findAll() {
        return userRepository.findAll().stream()
                .map(map::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Users findById() {
        return null;
    }

    @Override
    public void create(Users users) {

    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void delete(Long userId) {

    }
}
