package ru.sg.technicalTask.service;

import ru.sg.technicalTask.dto.UsersResponse;
import ru.sg.technicalTask.model.Users;

import java.util.List;

public interface UserService {
    List<UsersResponse> findAll();
    Users findById();
    void create(Users users);
    void update(Users users);
    void delete(Long userId);
}
