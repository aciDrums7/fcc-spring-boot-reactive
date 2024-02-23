package org.freecodecamp.springbootreactive.students;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentsMapper {
    StudentResponseDto toDto(StudentEntity entity);

    @Mapping(target = "id", ignore = true)
    StudentEntity toEntity(StudentRequestDto dto);
}
