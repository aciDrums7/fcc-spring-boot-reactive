package org.freecodecamp.springbootreactive.students;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(name = "students")
public class StudentEntity {

    @Id
    private Long id;

    private String firstname;

    private String lastname;

    private Integer age;
}
