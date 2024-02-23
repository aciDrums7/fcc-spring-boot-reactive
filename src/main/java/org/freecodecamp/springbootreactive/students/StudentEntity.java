package org.freecodecamp.springbootreactive.students;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "students")
public class StudentEntity {

    @Id
    private Long id;

    private String firstname;

    private String lastname;

    private Integer age;
}
