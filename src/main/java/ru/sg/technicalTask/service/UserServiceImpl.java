package ru.sg.technicalTask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sg.technicalTask.exception.ResourceNotFoundException;
import ru.sg.technicalTask.model.User;
import ru.sg.technicalTask.model.UserImage;
import ru.sg.technicalTask.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ImageService imageService;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found."));
    }

    @Override
    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found."));

        updateUser.setId(id);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setPatronymic(user.getPatronymic());
        updateUser.setDateOfBirth(user.getDateOfBirth());

        userRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User is not found.");
        }

        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void uploadImage(Long id, UserImage image) {
        User user = findById(id);
        String fileName = imageService.upload(image);
        user.getImages().add(fileName);
        userRepository.save(user);
    }
}
