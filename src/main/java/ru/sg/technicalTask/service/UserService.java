package ru.sg.technicalTask.service;

import ru.sg.technicalTask.model.User;
import ru.sg.technicalTask.model.UserImage;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void create(User user);
    void update(User user, Long id);
    void delete(Long id);
    void uploadImage(Long id, UserImage image);
}
