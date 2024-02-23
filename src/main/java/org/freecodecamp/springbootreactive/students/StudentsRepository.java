package org.freecodecamp.springbootreactive.students;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentsRepository extends ReactiveCrudRepository<StudentEntity, Long> {
    Flux<StudentEntity> findAllByFirstnameIgnoreCase(String firstname);
}
