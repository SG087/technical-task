package ru.sg.technicalTask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sg.technicalTask.dto.DetailsRequest;
import ru.sg.technicalTask.dto.DetailsResponse;
import ru.sg.technicalTask.mappers.Mapper;
import ru.sg.technicalTask.service.DetailsService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class DetailsController {

    private final DetailsService detailsService;
    private final Mapper mapper;

    @GetMapping
    public List<DetailsResponse> findAll() {
        return detailsService.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DetailsResponse findById(@PathVariable(name = "id") Long id) {
        return mapper.toResponse(detailsService.findById(id));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<HttpStatus> createDetailsAndAssignToUser(@Valid @RequestBody DetailsRequest request,
                                                                   @PathVariable(name = "userId") Long userId) {
        detailsService.create(mapper.toEntity(request), userId);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@Valid@RequestBody DetailsRequest request,
                                             @PathVariable(name = "id") Long id) {
        detailsService.update(mapper.toEntity(request), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
