package ru.sg.technicalTask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sg.technicalTask.exception.ResourceNotFoundException;
import ru.sg.technicalTask.model.Details;
import ru.sg.technicalTask.model.User;
import ru.sg.technicalTask.repository.DetailsRepository;
import ru.sg.technicalTask.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsServiceImpl implements DetailsService {

    private final DetailsRepository detailsRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Details> findAll() {
        return detailsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Details findById(Long id) {
        return detailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User data not found."));
    }

    @Override
    @Transactional
    public void create(Details details, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found."));

        user.setDetails(details);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(Details details, Long id) {
        Details updateDetails = detailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User data not found."));

        updateDetails.setId(id);
        updateDetails.setEmail(details.getEmail());
        updateDetails.setPhoneNumber(details.getPhoneNumber());

        detailsRepository.save(updateDetails);
    }
}
