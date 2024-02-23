package org.freecodecamp.springbootreactive.students;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StudentResponseDto(@NotEmpty String firstname, @NotEmpty String lastname, @NotNull @Min(value = 1) Integer age) {}
