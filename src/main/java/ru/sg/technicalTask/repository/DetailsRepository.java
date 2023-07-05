package ru.sg.technicalTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sg.technicalTask.model.Details;

public interface DetailsRepository extends JpaRepository<Details, Long> {
}
