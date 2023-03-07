package ma.pfe.mappers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentDto convertToDto(StudentEntity entity) {
        StudentDto studentDto = new StudentDto();
        long id = entity.getId();
        String name = entity.getName();
        studentDto.setId(id);
        studentDto.setName(name);
        return studentDto;
    }

    public StudentEntity convertToEntity(StudentDto dto) {
        StudentEntity studentEntity = new StudentEntity();
        long id = dto.getId();
        String name = dto.getName();
        studentEntity.setId(id);
        studentEntity.setName(name);
        return studentEntity;
    }

    public List<StudentEntity> convertToEntity(List<StudentDto> l) {
        return l.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    public List<StudentDto> convertToDto(List<StudentEntity> l) {
        return l.stream().map(entity -> convertToDto(entity)).collect(Collectors.toList());
    }

}
