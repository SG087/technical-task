package ru.sg.technicalTask.service;

import ru.sg.technicalTask.model.Details;

import java.util.List;

public interface DetailsService {
    List<Details> findAll();
    Details findById(Long id);
    void create(Details details, Long userId);
    void update(Details details, Long id);
}
