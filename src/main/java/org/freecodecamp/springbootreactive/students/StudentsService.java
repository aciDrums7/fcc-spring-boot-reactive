package org.freecodecamp.springbootreactive.students;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class StudentsService {

    public final StudentsRepository repository;

    public final StudentsMapper mapper;

    public Flux<StudentResponseDto> findAll() {
        return repository.findAll().map(mapper::toDto).delayElements(Duration.ofSeconds(1));
    }

    public Mono<StudentResponseDto> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public Mono<StudentResponseDto> save(StudentRequestDto student) {
        return repository.save(mapper.toEntity(student)).map(mapper::toDto);
    }
}
