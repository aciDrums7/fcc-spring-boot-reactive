package org.freecodecamp.springbootreactive.students;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService service;

    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<StudentResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<StudentResponseDto> findById(@PathVariable @NotNull @Min(value = 1) Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<StudentResponseDto> save(@RequestBody @NotNull StudentRequestDto student) {
        return service.save(student);
    }
}
