package org.freecodecamp.springbootreactive;

import org.freecodecamp.springbootreactive.students.StudentRequestDto;
import org.freecodecamp.springbootreactive.students.StudentsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReactiveApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentsService service) {
        return args -> {
            for (int i = 1; i < 100; i++) {
                service
                    .save(StudentRequestDto.builder().firstname("Name " + i).lastname("Surname " + i).age(i).build())
                    //! needed to execute the op and not just queue it, like the observables in RxJs
                    .subscribe();
            }
        };
    }
}
